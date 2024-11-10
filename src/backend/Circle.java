package backend;

import javafx.scene.canvas.GraphicsContext;

public class Circle extends ShapeImpl {

    public Circle(String shapeID) {
        super(shapeID);
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
