package backend;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Map;

public class Rectangle extends ShapeExtended {

    public Rectangle(String shapeID) {
        super(shapeID);
    }

    @Override
    public void draw(GraphicsContext canvas) {
        if (getPosition() != null && getProperties() != null) {
            double width = getProperties().getOrDefault("width", 0.0);
            double height = getProperties().getOrDefault("height", 0.0);
            canvas.setStroke(getColor());
            canvas.setFill(getFillColor());
            canvas.strokeRect(getPosition().getX(), getPosition().getY(), width, height);
            canvas.fillRect(getPosition().getX(), getPosition().getY(), width, height);
        }
    }
}
