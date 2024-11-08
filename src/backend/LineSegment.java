package backend;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Map;

public class LineSegment implements Shape{
    private Point2D position;
    private Map<String, Double> properties = new HashMap<>();
    private Color color;

    @Override
    public void setPosition(Point2D position) {
        this.position = position;
    }

    @Override
    public Point2D getPosition() {
        return position;
    }

    @Override
    public void setProperties(Map<String, Double> properties) {
        this.properties.putAll(properties);
    }

    @Override
    public Map<String, Double> getProperties() {
        return properties;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setFillColor(Color color) {}

    @Override
    public Color getFillColor() {
        return null;
    }

    @Override
    public void draw(GraphicsContext canvas) {
        if (position != null && properties != null) {
            double endPtX = properties.getOrDefault("endPtX", 0.0);
            double endPtY = properties.getOrDefault("endPtY", 0.0);
            canvas.setStroke(color);
            canvas.strokeLine(position.getX(), position.getY(), endPtX, endPtY);
        }
    }
}
