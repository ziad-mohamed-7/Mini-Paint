package frontend;

import backend.Circle;
import backend.DrawingEngine;
import backend.LineSegment;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextInputDialog;
import javafx.scene.paint.Color;

import java.util.Map;
import java.util.Optional;

import static frontend.MainWindow.getShapeOptions;

public class LineDialog extends ShapeDialog{
    private static int lineSegCounter = 1;

    @Override
    public void createShape(DrawingEngine engine, GraphicsContext gcCanvas) {
        TextInputDialog endPtsDialog = new TextInputDialog("100, 100");
        endPtsDialog.setTitle("Enter End Points");
        endPtsDialog.setHeaderText("Enter the end points (x, y):");
        endPtsDialog.setContentText("End Points:");
        Optional<String> endPtsResult = endPtsDialog.showAndWait();
        endPtsResult.ifPresent(endStr -> {
            String[] parts = endStr.split(",");
            double endPtX = Double.parseDouble(parts[0].trim());
            double endPtY = Double.parseDouble(parts[1].trim());
            super.createShape(engine, gcCanvas);
            getColorResult().ifPresent(color -> {
                LineSegment lineSegment = new LineSegment("line" + lineSegCounter);
                lineSegment.setPosition(new Point2D(getX(), getY()));
                lineSegment.setProperties(Map.of("endPtX", endPtX, "endPtY", endPtY));
                lineSegment.setColor(color);
                engine.addShape(lineSegment);
                getShapeOptions().add(lineSegment);
                engine.refresh(gcCanvas);
            });
        });
    }
}
