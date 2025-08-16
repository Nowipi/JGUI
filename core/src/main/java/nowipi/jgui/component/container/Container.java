package nowipi.jgui.component.container;


import nowipi.jgui.Color;
import nowipi.jgui.component.Component;
import nowipi.jgui.component.look.ComponentRenderer;
import nowipi.jgui.component.util.Bounds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Container implements Component {

    private final List<Component> children;
    private Color backgroundColor;
    private final FlowDirection flowDirection;
    private final FlowBegin flowBegin;
    private final Bounds bounds;

    public Container(Color backgroundColor, FlowDirection flowDirection, FlowBegin flowBegin, Component ...children) {
        this(backgroundColor, flowDirection, flowBegin, new ArrayList<>(Arrays.asList(children)));
    }

    public Container(Color backgroundColor, FlowDirection flowDirection, Component ...children) {
        this(backgroundColor, flowDirection, FlowBegin.START, new ArrayList<>(Arrays.asList(children)));
    }

    @SuppressWarnings("this-escape")
    private Container(Color backgroundColor, FlowDirection flowDirection, FlowBegin flowBegin, List<Component> children) {
        this.children = children;
        this.backgroundColor = backgroundColor;
        this.flowDirection = flowDirection;
        this.flowBegin = flowBegin;
        bounds = new Bounds(0,0,0,0,0);

        updateBounds();
    }

    private void moveToBegin(Bounds childBounds) {
        switch (flowBegin) {
            case START:
                childBounds.moveXStart(bounds.xStart());
                childBounds.moveYStart(bounds.yStart());
                break;
            case END:
                childBounds.moveXEnd(bounds.xEnd());
                childBounds.moveYEnd(bounds.yEnd());
                break;
        }
    }

    private void offset(Bounds childBounds, float calculatedWidth, float calculatedHeight) {
        switch (flowDirection) {
            case HORIZONTAL:
                switch (flowBegin) {
                    case START:
                        childBounds.moveXStart(bounds.xStart() + calculatedWidth);
                        break;
                    case END:
                        childBounds.moveXEnd(bounds.xEnd() - calculatedWidth);
                        break;
                }
                break;

            case VERTICAL:
                switch (flowBegin) {
                    case START:
                        childBounds.moveYStart(bounds.yStart() + calculatedHeight);
                        break;
                    case END:
                        childBounds.moveYEnd(bounds.yEnd() - calculatedHeight);

                        break;
                }
                break;
        }
    }


    public void updateBounds() {

        float calculatedWidth = 0;
        float calculatedHeight = 0;
        for (Component child : children) {
            Bounds childBounds = child.bounds();

            moveToBegin(childBounds);
            offset(childBounds, calculatedWidth, calculatedHeight);

            if (child instanceof Container containerChild) {
                containerChild.updateBounds();
            }

            float childWidth = childBounds.width();
            float childHeight = childBounds.height();

            switch (flowDirection) {
                case HORIZONTAL:
                    calculatedWidth += childWidth;
                    calculatedHeight = Math.max(calculatedHeight, childHeight);
                    break;
                case VERTICAL:
                    calculatedWidth = Math.max(calculatedWidth, childWidth);
                    calculatedHeight += childHeight;
                    break;
            }
        }

        switch (flowBegin) {
            case START:
                bounds.setWidthFromStart(calculatedWidth);
                bounds.setHeightFromStart(calculatedHeight);
                break;
            case END:
                bounds.setWidthFromEnd(calculatedWidth);
                bounds.setHeightFromEnd(calculatedHeight);
                break;
        }
    }

    @Override
    public void draw(ComponentRenderer renderer) {
        renderer.drawFilledBounds(bounds, backgroundColor);
        for (Component child : children) {
            child.draw(renderer);
        }

    }

    public Bounds bounds() {
        return bounds;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public void addChild(Component child) {
        children.add(child);
        updateBounds();
    }
    public void removeChild(Component child) {
        children.remove(child);
        updateBounds();
    }

    public void clearChildren() {
        children.clear();
        updateBounds();
    }
}
