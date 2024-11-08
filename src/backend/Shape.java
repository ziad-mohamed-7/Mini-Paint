package backend;

import javafx.geometry.Point2D;
import java.util.Map;
import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;


public interface Shape {
    public void setPosition(Point2D position);
    public Point2D getPosition();

    public void setProperties(Map<String, Double> properties);
    public Map<String, Double> getProperties();

    public void setColor(Color color);
    public Color getColor();
    public void setFillColor(Color color);
    public Color getFillColor();

    public void draw(GraphicsContext canvas);
}