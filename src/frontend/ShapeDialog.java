package frontend;

import backend.DrawingEngine;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextInputDialog;
import javafx.scene.paint.Color;

import java.util.Optional;

public abstract class ShapeDialog {
    private double x;
    private double y;
    private Optional<Color> colorResult;
    private Optional<Color> fillColorResult;

    public void createShape(DrawingEngine engine, GraphicsContext gcCanvas) {
        TextInputDialog positionDialog = new TextInputDialog("200, 200");
        positionDialog.setTitle("Enter Position");
        positionDialog.setHeaderText("Enter the position (x, y):");
        positionDialog.setContentText("Position:");
        Optional<String> positionResult = positionDialog.showAndWait();
        positionResult.ifPresent(positionStr -> {
            String[] parts = positionStr.split(",");
            x = Double.parseDouble(parts[0].trim());
            y = Double.parseDouble(parts[1].trim());
            ColorPicker colorPicker = new ColorPicker(Color.BLACK);
            Dialog<Color> colorDialog = new Dialog<>();
            colorDialog.setTitle("Pick Color");
            colorDialog.setHeaderText("Pick a color for the shape:");
            colorDialog.getDialogPane().setContent(colorPicker);
            colorDialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
            colorDialog.setResultConverter(dialogButton -> {
                if (dialogButton == ButtonType.OK) {
                    return colorPicker.getValue();
                }
                return null;
            });
            colorResult = colorDialog.showAndWait();
        });
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Optional<Color> getColorResult() {
        return colorResult;
    }

    public Optional<Color> getFillColorResult() {
        return fillColorResult;
    }

    public void fillColorDialog() {
        ColorPicker fillColorPicker = new ColorPicker(Color.BLACK);
        Dialog<Color> fillColorDialog = new Dialog<>();
        fillColorDialog.setTitle("Pick a Fill Color");
        fillColorDialog.setHeaderText("Pick a Fill color for the shape:");
        fillColorDialog.getDialogPane().setContent(fillColorPicker);
        fillColorDialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        fillColorDialog.setResultConverter(dialogButton -> {
            if (dialogButton == ButtonType.OK) {
                return fillColorPicker.getValue();
            }
            return null;
        });
        fillColorResult = fillColorDialog.showAndWait();
    }
}
