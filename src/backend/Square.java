package backend;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Map;

public class Square extends ShapeExtended {

    public Square(String shapeID) {
        super(shapeID);
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
