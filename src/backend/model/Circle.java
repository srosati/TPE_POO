package backend.model;

import javafx.scene.paint.Color;

public class Circle extends Ellipse {

    public Circle(Color fillColor, Color borderColor, double borderWidth, Point centerPoint, double radius) {
        super(fillColor, borderColor, borderWidth, centerPoint, radius, radius);
    }

    @Override
    public String toString() {
        return String.format("Círculo [Centro: %s, Radio: %.2f]", getCenterPoint(), getRadiusX());
    }

}
