package frontend;

import backend.Circle;
import backend.DrawingEngine;
import backend.Main;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.*;

public class MainWindow extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage window) throws Exception {
//        Main engine = new Main();
        DrawingEngine engine = new Main();

        Canvas canvas = new Canvas(500, 500);
        GraphicsContext gcCanvas = canvas.getGraphicsContext2D();
//        Pane drawingArea = new Pane(canvas);

        Button circleButton = new Button("Circle");
        circleButton.setOnAction(e -> {
            TextInputDialog dialog = new TextInputDialog("50");
            dialog.setTitle("Enter Radius");
            dialog.setHeaderText("Enter the radius for the circle:");
            dialog.setContentText("Radius:");
            Optional<String> result = dialog.showAndWait();
            result.ifPresent(radiusStr -> {
                double radius = Double.parseDouble(radiusStr);
                Circle circle = new Circle("circle");
                circle.setPosition(new Point2D(200, 200));
                circle.setProperties(Map.of("radius", radius));
                circle.setColor(Color.BLACK);
                circle.setFillColor(Color.YELLOW);
                engine.addShape(circle);
                engine.refresh(gcCanvas);
            });
        });
        Button lineButton = new Button("Line Segment");
        lineButton.setOnAction(e -> {});
        Button squareButton = new Button("Square");
        squareButton.setOnAction(e -> {});
        Button rectButton = new Button("Rectangle");
        rectButton.setOnAction(e -> {});
        HBox layout1 = new HBox(50, circleButton, lineButton, squareButton, rectButton);
        layout1.setAlignment(Pos.TOP_RIGHT);


        VBox layout2 = new VBox(20, layout1, canvas);

        Label slctShapeLabel = new Label("Select Shape");
//        ObservableList<String> shapeOptions = FXCollections.observableList(Arrays.asList(engine.getShapes()));
//        ComboBox<String> optionsComboBox = new ComboBox<>(shapeOptions);
//        optionsComboBox.setValue("active");
        Button colorizeButton = new Button("Colorize");
        colorizeButton.setOnAction(e -> {});
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> {});
        HBox layout3 = new HBox(10, colorizeButton, deleteButton);
        VBox layout4 = new VBox(10, slctShapeLabel, layout3);
        layout4.setAlignment(Pos.CENTER);





        HBox layout5 = new HBox(10, layout4, layout2);
//        layout5.setAlignment(Pos.CENTER);


        Scene scene = new Scene(layout5, 800, 600);
        window.setScene(scene);
        window.show();
    }
}
