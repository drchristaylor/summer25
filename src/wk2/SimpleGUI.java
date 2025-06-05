package wk2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SimpleGUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private Label label;

    @Override
    public void start(Stage primaryStage) {
        Pane root = new VBox();
        Button clickMe = new Button("Click Me");
        label = new Label("Blur Me, no I really mean it.");
        clickMe.setOnAction(this::handleBlurButton);
        root.getChildren().add(label);
        root.getChildren().add(clickMe);

        primaryStage.setTitle("Simple GUI");
        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.show();
    }

    private void handleBlurButton(ActionEvent event) {
        if(label.getEffect()==null) {
            label.setEffect(new BoxBlur());
        } else {
            label.setEffect(null);
        }
    }
}