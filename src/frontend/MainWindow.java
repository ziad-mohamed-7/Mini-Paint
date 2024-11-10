package frontend;

import backend.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.*;

public class MainWindow extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    static ObservableList<ShapeImpl> shapeOptions = FXCollections.observableArrayList();

    @Override
    public void start(Stage window) {
        DrawingEngine engine = new DwgEngineImpl();

        for (Shape shape : engine.getShapes()) {
            shapeOptions.add((ShapeImpl) shape);
        }


        Canvas canvas = new Canvas(500, 500);
        GraphicsContext gcCanvas = canvas.getGraphicsContext2D();
        Pane drawingArea = new Pane(canvas);
        drawingArea.getStyleClass().add("drawing-area");

        Button circleButton = new Button("Circle");
        circleButton.setOnAction(_ ->{
            CircleDialog circleDialog = new CircleDialog();
            circleDialog.createShape(engine, gcCanvas);
        });
        Button lineButton = new Button("Line Segment");
        lineButton.setOnAction(_ -> {
            LineDialog lineDialog = new LineDialog();
            lineDialog.createShape(engine, gcCanvas);
        });
        Button squareButton = new Button("Square");
        squareButton.setOnAction(_ -> {
            SquareDialog squareDialog = new SquareDialog();
            squareDialog.createShape(engine, gcCanvas);
        });
        Button rectButton = new Button("Rectangle");
        rectButton.setOnAction(_ -> {
            RectDialog rectDialog = new RectDialog();
            rectDialog.createShape(engine, gcCanvas);
        });

        HBox buttonBox = new HBox(20, circleButton, lineButton, squareButton, rectButton);
        buttonBox.setAlignment(Pos.CENTER);


        VBox drawingLayout = new VBox(20, buttonBox, drawingArea);


        Label slctShapeLabel = new Label("Select Shape");
        ComboBox<ShapeImpl> optionsComboBox = new ComboBox<>(shapeOptions);


        Button colorizeButton = new Button("Colorize");
        colorizeButton.setOnAction(_ -> {
            ShapeImpl shapeSelected = optionsComboBox.getValue();
            if (shapeSelected != null) {
                ColorPicker colorPicker = new ColorPicker(Color.BLACK);
                Dialog<Color> colorDialog = new Dialog<>();
                colorDialog.setTitle("Choose Color");
                colorDialog.setHeaderText("Choose a color for the shape:");
                colorDialog.getDialogPane().setContent(colorPicker);
                colorDialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
                colorDialog.setResultConverter(dialogButton -> {
                    if (dialogButton == ButtonType.OK) {
                        return colorPicker.getValue();
                    }
                    return null;
                });
                Optional<Color> colorResult = colorDialog.showAndWait();
                colorResult.ifPresent(color -> {
                    if (shapeSelected instanceof LineSegment) {
                        shapeSelected.setColor(color);
                        engine.refresh(gcCanvas);
                    }else {
                        shapeSelected.setColor(color);
                        ColorPicker fillColorPicker = new ColorPicker(Color.BLACK);
                        Dialog<Color> fillColorDialog = new Dialog<>();
                        fillColorDialog.setTitle("Choose Fill Color");
                        fillColorDialog.setHeaderText("Choose a fill color for the shape:");
                        fillColorDialog.getDialogPane().setContent(fillColorPicker);
                        fillColorDialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
                        fillColorDialog.setResultConverter(dialogButton -> {
                            if (dialogButton == ButtonType.OK) {
                                return fillColorPicker.getValue();
                            }
                            return null;
                        });
                        Optional<Color> fillColorResult = fillColorDialog.showAndWait();
                        fillColorResult.ifPresent(fillColor -> {
                            shapeSelected.setFillColor(fillColor);
                            engine.refresh(gcCanvas);
                        });
                    }
                });
            }
        });
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(_ -> {
            ShapeImpl shapeSelected = optionsComboBox.getValue();
            if (shapeSelected != null) {
                engine.removeShape(shapeSelected);
                shapeOptions.remove(shapeSelected);
                engine.refresh(gcCanvas);
            }
        });
        HBox actionBox = new HBox(10, colorizeButton, deleteButton);
        VBox controlBox = new VBox(10, slctShapeLabel, optionsComboBox, actionBox);
        controlBox.setAlignment(Pos.CENTER);

        BorderPane mainLayout = new BorderPane();
        mainLayout.setPadding(new Insets(10));
        mainLayout.setRight(drawingLayout);
        mainLayout.setLeft(controlBox);


        Scene scene = new Scene(mainLayout, 800, 600);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        window.setScene(scene);
        window.setTitle("Vector Drawing Application");
        window.show();
    }

    public static ObservableList<ShapeImpl> getShapeOptions() {
        return shapeOptions;
    }
}