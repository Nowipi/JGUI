package nowipi.jgui.component.util;

import nowipi.primitives.Vector2f;

public final class Bounds {

    private float xStart;
    private float xEnd;
    private float yStart;
    private float yEnd;
    private float width;
    private float height;
    private float degreesOfRotationAroundCenter;
    private float xCenter;
    private float yCenter;

    public Bounds(float xStart, float xEnd, float yStart, float yEnd, float degreesOfRotationAroundCenter) {

        if (xStart > xEnd) {
            throw new IllegalArgumentException("xStart > xEnd");
        }

        if (yStart > yEnd) {
            throw new IllegalArgumentException("yStart > yEnd");
        }

        this.xStart = xStart;
        this.xEnd = xEnd;
        this.yStart = yStart;
        this.yEnd = yEnd;

        width = width(xEnd, xStart);
        height = height(yEnd, yStart);

        xCenter = centerX(xStart, width);
        yCenter = centerY(yStart, height);

        this.degreesOfRotationAroundCenter = degreesOfRotationAroundCenter;
    }

    private static float width(float xEnd, float xStart) {
        return xEnd - xStart;
    }

    private static float height(float yEnd, float yStart) {
        return yEnd - yStart;
    }

    private static float centerX(float xStart, float width) {
        return xStart + width / 2f;
    }

    private static float centerY(float yStart, float height) {
        return yStart + height / 2f;
    }

    public void setWidthFromStart(float width) {
        this.width = width;
        xEnd = xStart + width;
        xCenter = centerX(xStart, this.width);
    }

    public void setHeightFromStart(float height) {
        this.height = height;
        yEnd = yStart + this.height;
        yCenter = centerY(yStart, this.height);
    }

    public void setWidthFromEnd(float width) {
        this.width = width;
        xStart = xEnd - width;
        xCenter = centerX(xStart, this.width);
    }

    public void setHeightFromEnd(float height) {
        this.height = height;
        yStart = yEnd - this.height;
        yCenter = centerY(yStart, this.height);
    }

    public void moveXStart(float toX) {
        xStart = toX;
        xEnd = xStart + width;
        xCenter = centerX(xStart, width);
    }

    public void moveXEnd(float toX) {
        xEnd = toX;
        xStart = xEnd - width;
        xCenter = centerX(xStart, width);
    }

    public void moveYStart(float toY) {
        yStart = toY;
        yEnd = yStart + height;
        yCenter = centerY(yStart, height);
    }

    public void moveYEnd(float toY) {
        yEnd = toY;
        yStart = yEnd - height;
        yCenter = centerY(yStart, height);
    }

    public float area() {
        return width() * height();
    }

    public void rotateAroundCenter(float amount) {
        degreesOfRotationAroundCenter += amount;
    }

    private static Vector2f rotate(float x, float y, float cx, float cy, float radians) {
        float dx = x - cx;
        float dy = y - cy;
        float rx = (float) (dx * Math.cos(radians) - dy * Math.sin(radians));
        float ry = (float) (dx * Math.sin(radians) + dy * Math.cos(radians));
        return new Vector2f(rx + cx, ry + cy);
    }

    public Vector2f[] vertices() {
        float radians = (float) Math.toRadians(degreesOfRotationAroundCenter);
        return new Vector2f[]{
                rotate(xStart, yStart, xCenter, yCenter, radians),
                rotate(xEnd, yStart, xCenter, yCenter, radians),
                rotate(xEnd, yEnd, xCenter, yCenter, radians),
                rotate(xStart, yEnd, xCenter, yCenter, radians)
        };
    }

    public float width() {
        return width;
    }

    public float height() {
        return height;
    }

    public boolean isInside(float x, float y) {
        float translatedX = x - xCenter;
        float translatedY = y - yCenter;

        float radians = (float) Math.toRadians(-degreesOfRotationAroundCenter);
        float unrotatedX = (float) (translatedX * Math.cos(radians) - translatedY * Math.sin(radians));
        float unrotatedY = (float) (translatedX * Math.sin(radians) + translatedY * Math.cos(radians));

        float halfWidth = width / 2f;
        float halfHeight = height / 2f;

        return unrotatedX >= -halfWidth && unrotatedX <= halfWidth &&
                unrotatedY >= -halfHeight && unrotatedY <= halfHeight;
    }

    public float xStart() {
        return xStart;
    }

    public float xEnd() {
        return xEnd;
    }

    public float yStart() {
        return yStart;
    }

    public float yEnd() {
        return yEnd;
    }
}
