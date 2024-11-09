package frontend;

import backend.Main;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainWindow extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage window) throws Exception {
        Main engine = new Main();

        Button circleButton = new Button("Circle");
        circleButton.setOnAction(e -> {});
        Button lineButton = new Button("Line Segment");
        lineButton.setOnAction(e -> {});
        Button squareButton = new Button("Square");
        squareButton.setOnAction(e -> {});
        Button rectButton = new Button("Rectangle");
        rectButton.setOnAction(e -> {});
        HBox layout1 = new HBox(circleButton, lineButton, squareButton, rectButton);
        Canvas canvas = new Canvas(800, 600);
        GraphicsContext gcCanvas = canvas.getGraphicsContext2D();
//        Pane drawingArea = new Pane(canvas);
        VBox layout2 = new VBox(layout1, canvas);

        Label slctShapeLabel = new Label("Select Shape");
//        ObservableList<String> shapeOptions = FXCollections.observableList(Arrays.asList(engine.getShapes()));
//        ComboBox<String> stautsComboBox = new ComboBox<>(statusOptions);
//        stautsComboBox.setValue("active");




        HBox layout5 = new HBox();


        Scene scene = new Scene(layout5, 1000, 600);
        window.setScene(scene);
        window.show();
    }
}
