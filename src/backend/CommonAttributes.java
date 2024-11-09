package backend;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Map;

public abstract class CommonAttributes implements Shape{
    private String shapeID;
    private Point2D position;
    private Map<String, Double> properties = new HashMap<>();
    private Color color;
    private Color fillColor;

    public CommonAttributes(String shapeID, Point2D position, Map<String, Double> properties, Color color, Color fillColor) {
        this.shapeID = shapeID;
        this.position = position;
        this.properties = properties;
        this.color = color;
        this.fillColor = fillColor;
    }

    public CommonAttributes(String shapeID, Point2D position, Map<String, Double> properties, Color color) {
        this.shapeID = shapeID;
        this.position = position;
        this.properties = properties;
        this.color = color;
    }

    public String getShapeID() {
        return shapeID;
    }

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
    public abstract void draw(GraphicsContext canvas);

//        if (position != null && color != null) {
//            double radius = properties.getOrDefault("radius", 0.0);
//            canvas.setStroke(color);
//            canvas.setFill(fillColor);
//            canvas.strokeOval(position.getX() - radius, position.getY() - radius, 2 * radius, 2 * radius);
//            canvas.fillOval(position.getX() - radius, position.getY() - radius, 2 * radius, 2 * radius);
//        }

}
