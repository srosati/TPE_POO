package backend.model;

import backend.DrawData;
import backend.Selector;
import javafx.scene.paint.Color;

public class Ellipse extends FillableFigure {

    private final double radiusX, radiusY;
    private final Point centerPoint;

    public Ellipse(Color fillColor, Color borderColor, double borderWidth, Point centerPoint, double radiusX, double radiusY) {
        super(fillColor, borderColor, borderWidth);
        this.centerPoint = centerPoint;
        this.radiusX = radiusX;
        this.radiusY = radiusY;
    }

    public Point getCenterPoint() {
        return centerPoint;
    }

    @Override
    protected Point[] getPoints() {
        return new Point[]{centerPoint};
    }

    @Override
    public boolean contains(Point point) {
        return Math.pow((centerPoint.getX() - point.getX())/radiusX, 2) + Math.pow((centerPoint.getY() - point.getY())/radiusY, 2) <= 1;
    }

    @Override
    public boolean isContained(Selector selector) {
        Point left = new Point(centerPoint.getX() - radiusX, centerPoint.getY());
        Point right = new Point(centerPoint.getX() + radiusX, centerPoint.getY());
        Point up = new Point(centerPoint.getX(), centerPoint.getY() + radiusY);
        Point down = new Point(centerPoint.getX(), centerPoint.getY() - radiusY);
        return selector.contains(left) && selector.contains(right)
                && selector.contains(up) && selector.contains(down);
    }


    public double getRadiusX() {
        return radiusX;
    }

    @Override
    public String toString() {
        return String.format("Elipse [Centro: %s, Radio X: %.2f, Radio Y: %.2f]", centerPoint, radiusX, radiusY);
    }

    @Override
    public DrawData getData() {
        return new DrawData(centerPoint.getX() - radiusX, centerPoint.getY() - radiusY, 2*radiusX, 2* radiusY);
    }
}
