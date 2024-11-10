package frontend;

import backend.DrawingEngine;
import backend.Square;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextInputDialog;

import java.util.Map;
import java.util.Optional;

import static frontend.MainWindow.getShapeOptions;

public class SquareDialog extends ShapeDialog {
    private static int squareCounter = 1;

    @Override
    public void createShape(DrawingEngine engine, GraphicsContext gcCanvas) {
        TextInputDialog lengthDialog = new TextInputDialog("50");
        lengthDialog.setTitle("Enter Length");
        lengthDialog.setHeaderText("Enter the side length:");
        lengthDialog.setContentText("Length:");
        Optional<String> lengthResult = lengthDialog.showAndWait();
        lengthResult.ifPresent(lenStr -> {
            double side = Double.parseDouble(lenStr);
            super.createShape(engine, gcCanvas);
            getColorResult().ifPresent(color -> {
                fillColorDialog();
                getFillColorResult().ifPresent(fillColor -> {
                    Square square = new Square("square" + squareCounter);
                    square.setPosition(new Point2D(getX(), getY()));
                    square.setProperties(Map.of("side", side));
                    square.setColor(color);
                    square.setFillColor(fillColor);
                    engine.addShape(square);
                    getShapeOptions().add(square);
                    engine.refresh(gcCanvas);
                });
            });
        });
    }
}