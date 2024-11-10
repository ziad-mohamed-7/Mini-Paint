package backend;

import javafx.scene.canvas.GraphicsContext;
import java.util.ArrayList;

public class DwgEngineImpl implements DrawingEngine{
    private ArrayList<Shape> shapes = new ArrayList<>();

    @Override
    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    @Override
    public void removeShape(Shape shape) {
        shapes.remove(shape);
    }

    @Override
    public Shape[] getShapes() {
        return shapes.toArray(new Shape[0]);
    }

    @Override
    public void refresh(GraphicsContext canvas) {
        canvas.clearRect(0, 0, canvas.getCanvas().getWidth(), canvas.getCanvas().getHeight());
        for (Shape shape : shapes) {
            shape.draw(canvas);
        }
    }
}
