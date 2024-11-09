package backend;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Map;

public class Square extends CommonAttributes {

    public Square(String shapeID, Point2D position, Map<String, Double> properties, Color color, Color fillColor) {
        super(shapeID, position, properties, color, fillColor);
    }

    @Override
    public void draw(GraphicsContext canvas) {
        if (getPosition() != null && getProperties() != null) {
            double side = getProperties().getOrDefault("side", 0.0);
            canvas.setStroke(getColor());
            canvas.setFill(getFillColor());
            canvas.strokeRect(getPosition().getX(), getPosition().getY(), side, side);
            canvas.fillRect(getPosition().getX(), getPosition().getY(), side, side);
        }
    }
}
