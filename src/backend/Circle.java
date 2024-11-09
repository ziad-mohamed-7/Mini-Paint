package backend;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Map;

public class Circle extends CommonAttributes {

    public Circle(String shapeID, Point2D position, Map<String, Double> properties, Color color, Color fillColor) {
        super(shapeID, position, properties, color, fillColor);
    }

    @Override
    public void draw(GraphicsContext canvas) {
        if (getPosition() != null && getProperties() != null) {
            double radius = getProperties().getOrDefault("radius", 0.0);
            canvas.setStroke(getColor());
            canvas.setFill(getFillColor());
            canvas.strokeOval(getPosition().getX() - radius, getPosition().getY() - radius, 2 * radius, 2 * radius);
            canvas.fillOval(getPosition().getX() - radius, getPosition().getY() - radius, 2 * radius, 2 * radius);
        }
    }
}
