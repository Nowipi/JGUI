package nowipi.jgui.component.container;


import nowipi.jgui.Color;
import nowipi.jgui.component.Component;
import nowipi.jgui.component.look.ComponentRenderer;
import nowipi.primitives.Rectangle;
import nowipi.primitives.Vector2f;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Container implements Component {

    private final List<Component> children;
    private Color backgroundColor;
    private final FlowDirection flowDirection;
    private Rectangle bounds;

    public Container(Color backgroundColor, FlowDirection flowDirection, Component ...children) {
        this(backgroundColor, flowDirection, new ArrayList<>(Arrays.asList(children)));
    }

    @SuppressWarnings("this-escape")
    private Container(Color backgroundColor, FlowDirection flowDirection, List<Component> children) {
        this.children = children;
        this.backgroundColor = backgroundColor;
        this.flowDirection = flowDirection;

        updateBounds();
    }

    @Override
    public void draw(ComponentRenderer renderer) {
        renderer.drawQuad(bounds, backgroundColor);
        for (Component child : children) {
            child.draw(renderer);
        }

    }

    private void add(Rectangle src, Rectangle dst) {
        Vector2f addend = switch(flowDirection) {
            case VERTICAL -> new Vector2f(0, src.height());
            case HORIZONTAL -> new Vector2f(src.width(), 0);
        };
        dst.topLeft.add(addend);
        dst.topRight.add(addend);
        dst.bottomRight.add(addend);
        dst.bottomLeft.add(addend);
    }

    public void updateBounds() {
        float maxWidth = 0;
        float maxHeight = 0;
        float accumulatedWidth = 0;
        float accumulatedHeight = 0;

        Rectangle lastBounds = new Rectangle(0,0,0,0);
        for (Component child : children) {

            Rectangle childBounds = child.bounds();
            final float childWidth = childBounds.width();
            final float childHeight = childBounds.height();
            add(lastBounds, childBounds);

            accumulatedWidth += childWidth;
            accumulatedHeight += childHeight;

            if (maxWidth < childWidth) {
                maxWidth = childWidth;
            }

            if (maxHeight < childHeight) {
                maxHeight = childHeight;
            }

            lastBounds = childBounds;
        }

        float width = 0;
        float height = 0;
        switch (flowDirection) {
            case VERTICAL -> {
                width = maxWidth;
                height = accumulatedHeight;
            }
            case HORIZONTAL -> {
                width = accumulatedWidth;
                height = maxHeight;
            }
        }

        bounds = Rectangle.fromBottomLeft(0, 0, width, height);
    }

    public Rectangle bounds() {
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
