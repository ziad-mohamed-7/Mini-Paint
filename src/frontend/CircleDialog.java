package frontend;

import backend.Circle;
import backend.DrawingEngine;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextInputDialog;

import java.util.Map;
import java.util.Optional;

import static frontend.MainWindow.getShapeOptions;

public class CircleDialog extends ShapeDialog {
    private static int circleCounter = 1;
    @Override
    public void createShape(DrawingEngine engine, GraphicsContext gcCanvas) {
        TextInputDialog radiusDialog = new TextInputDialog("50");
        radiusDialog.setTitle("Enter Radius");
        radiusDialog.setHeaderText("Enter the radius for the circle:");
        radiusDialog.setContentText("Radius:");
        Optional<String> radiusResult = radiusDialog.showAndWait();
        radiusResult.ifPresent(radiusStr -> {
            double radius = Double.parseDouble(radiusStr);
            super.createShape(engine, gcCanvas);
            getColorResult().ifPresent(color -> {
                fillColorDialog();
                getFillColorResult().ifPresent(fillColor -> {
                    Circle circle = new Circle("circle" + circleCounter);
                    circleCounter++;
                    circle.setPosition(new Point2D(getX(), getY()));
                    circle.setProperties(Map.of("radius", radius));
                    circle.setColor(color);
                    circle.setFillColor(fillColor);
                    engine.addShape(circle);
                    getShapeOptions().add(circle);
                    engine.refresh(gcCanvas);
                });
            });
        });

    }
}
