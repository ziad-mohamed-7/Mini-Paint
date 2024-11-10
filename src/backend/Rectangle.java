package backend;

import javafx.scene.canvas.GraphicsContext;

public class Rectangle extends ShapeImpl {

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
