package frontend;

import backend.DrawingEngine;
import backend.Rectangle;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextInputDialog;

import java.util.Map;
import java.util.Optional;

import static frontend.MainWindow.getShapeOptions;

public class RectDialog extends ShapeDialog{
    private static int rectCounter = 1;

    @Override
    public void createShape(DrawingEngine engine, GraphicsContext gcCanvas) {
        TextInputDialog lengthDialog = new TextInputDialog("200, 100");
        lengthDialog.setTitle("Enter Length");
        lengthDialog.setHeaderText("Enter the length (width, height):");
        lengthDialog.setContentText("Length:");
        Optional<String> lengthResult = lengthDialog.showAndWait();
        lengthResult.ifPresent(lenStr -> {
            String[] parts = lenStr.split(",");
            double width = Double.parseDouble(parts[0].trim());
            double height = Double.parseDouble(parts[1].trim());
            super.createShape(engine, gcCanvas);
            getColorResult().ifPresent(color -> {
                fillColorDialog();
                getFillColorResult().ifPresent(fillColor -> {
                    Rectangle rectangle = new Rectangle("rectangle" + rectCounter);
                    rectangle.setPosition(new Point2D(getX(), getY()));
                    rectangle.setProperties(Map.of("width", width, "height", height));
                    rectangle.setColor(color);
                    rectangle.setFillColor(fillColor);
                    engine.addShape(rectangle);
                    getShapeOptions().add(rectangle);
                    engine.refresh(gcCanvas);
                });
            });
        });
    }
}