package wk1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HelloWorld extends Application {

    @Override
    public void start(Stage stage) {
        Label message = new Label("Hello World!");
        message.setFont(new Font("Times New Roman", 50));
        Pane box = new FlowPane();
        box.getChildren().add(message);
        box.getChildren().add(new Label("Hello universe"));
        box.getChildren().add(new Button("Click Me!"));
        Scene scene = new Scene(box);

        stage.setTitle("Title bar");
        stage.setWidth(400);
        stage.setHeight(400);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}