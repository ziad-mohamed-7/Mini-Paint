package backend;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Map;

public class LineSegment extends CommonAttributes{
    public LineSegment(String shapeID, Point2D position, Map<String, Double> properties, Color color) {
        super(shapeID, position, properties, color);
    }

    @Override
    public void draw(GraphicsContext canvas) {
        if (getPosition() != null && getProperties() != null) {
            double endPtX = getProperties().getOrDefault("endPtX", 0.0);
            double endPtY = getProperties().getOrDefault("endPtY", 0.0);
            canvas.setStroke(getColor());
            canvas.strokeLine(getPosition().getX(), getPosition().getY(), endPtX, endPtY);
        }
    }
}
