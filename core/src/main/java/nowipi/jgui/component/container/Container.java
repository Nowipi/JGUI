package nowipi.jgui.component.container;


import nowipi.jgui.component.Component;
import nowipi.jgui.component.look.Look;
import nowipi.primitives.Rectangle;
import nowipi.primitives.Vector2f;

public abstract class Container<C extends Component> implements Look<C> {

    private final FlowDirection flowDirection;

    @SuppressWarnings("this-escape")
    public Container(FlowDirection flowDirection, Rectangle ...bounds) {
        this.flowDirection = flowDirection;

        for (Rectangle bound : bounds) {
            addBounds(bound);
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

    //TODO update children positions
    private Rectangle calculateBounds() {
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
        return new Rectangle(Vector2f.newZeroVector(), new Vector2f(width, 0), new Vector2f(width, height), new Vector2f(0, height));
    }

    private Rectangle lastBounds = new Rectangle(0,0,0,0);
    private float maxWidth = 0;
    private float maxHeight = 0;
    private float accumulatedWidth = 0;
    private float accumulatedHeight = 0;

    public void addBounds(Rectangle bounds) {
        final float childWidth = bounds.width();
        final float childHeight = bounds.height();
        add(lastBounds, bounds);

        accumulatedWidth += childWidth;
        accumulatedHeight += childHeight;

        if (maxWidth < childWidth) {
            maxWidth = childWidth;
        }

        if (maxHeight < childHeight) {
            maxHeight = childHeight;
        }

        lastBounds = bounds;
    }

    @Override
    public Rectangle bounds(C component) {
        return calculateBounds();
    }
}
