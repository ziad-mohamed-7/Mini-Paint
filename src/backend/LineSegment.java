package backend;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Map;

public class LineSegment extends ShapeExtended {
    public LineSegment(String shapeID) {
        super(shapeID);
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
