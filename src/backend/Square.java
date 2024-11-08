package backend;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Map;

public class Square implements Shape{
    private Point2D position;
    private Map<String, Double> properties = new HashMap<>();
    private Color color;
    private Color fillColor;

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
    public void setFillColor(Color color) {
        this.fillColor = color;
    }

    @Override
    public Color getFillColor() {
        return fillColor;
    }

    @Override
    public void draw(GraphicsContext canvas) {
        if (position != null && properties != null) {
            double side = properties.getOrDefault("side", 0.0);
            canvas.setStroke(color);
            canvas.setFill(fillColor);
            canvas.strokeRect(position.getX(), position.getY(), side, side);
            canvas.fillRect(position.getX(), position.getY(), side, side);
        }
    }
}
