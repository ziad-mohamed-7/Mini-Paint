package backend;

import javafx.scene.shape.Shape;
import javafx.scene.canvas.GraphicsContext;

public interface DrawingEngine {
    public void addShape(Shape shape);
    public void removeShape(Shape shape);

    public Shape[] getShapes();

    public void refresh(GraphicsContext canvas);
}