package nowipi.jgui.component.container;

import nowipi.jgui.Color;
import nowipi.jgui.component.look.DrawCommand;
import nowipi.jgui.component.look.Look;
import nowipi.jgui.component.look.QuadDrawCommand;
import nowipi.primitives.Rectangle;
import nowipi.primitives.Vector2f;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Container<L extends Look> implements Look {

    private final List<Look> children;
    private Color backgroundColor;
    private final FlowDirection flowDirection;
    private Rectangle bounds;

    public Container(Color backgroundColor, FlowDirection flowDirection, Look ...children) {
        this(backgroundColor, flowDirection, new ArrayList<>(Arrays.asList(children)));
    }

    @SuppressWarnings("this-escape")
    private Container(Color backgroundColor, FlowDirection flowDirection, List<Look> children) {
        this.children = children;
        this.backgroundColor = backgroundColor;
        this.flowDirection = flowDirection;

        updateBounds();
    }

    @Override
    public List<DrawCommand> draw() {
        List<DrawCommand> drawCommands = new ArrayList<>();

        drawCommands.add(new QuadDrawCommand(bounds, backgroundColor));

        for (Look child : children) {

            drawCommands.addAll(child.draw());
        }
        return drawCommands;
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

    //TODO update children positions
    public void updateBounds() {
        float maxWidth = 0;
        float maxHeight = 0;
        float accumulatedWidth = 0;
        float accumulatedHeight = 0;

        Rectangle lastBounds = new Rectangle(0,0,0,0);
        for (Look child : children) {

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

        bounds = new Rectangle(Vector2f.newZeroVector(), new Vector2f(width, 0), new Vector2f(width, height), new Vector2f(0, height));
    }

    @Override
    public Rectangle bounds() {
        return bounds;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public void addChild(L child) {
        children.add(child);
        updateBounds();
    }
    public void removeChild(L child) {
        children.remove(child);
        updateBounds();
    }

    public void clearChildren() {
        children.clear();
        updateBounds();
    }
}
