package wk1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HelloWorld extends Application {

    @Override
    public void start(Stage stage) {
        Label message = new Label("label");
        TextField tf = new TextField();
        Button button = new Button("Click Me!");
        tf.setOnAction(this::textFieldHandler);
        button.setOnAction(this::buttonHandler);

        GridPane box = new GridPane();
        box.add(message, 0, 0);
        box.add(tf, 1, 0);
        box.add(button, 0, 1);
        Scene scene = new Scene(box);

        stage.setTitle("Title bar");
        stage.setWidth(400);
        stage.setHeight(400);
        stage.setScene(scene);
        stage.show();
    }

    private void buttonHandler(ActionEvent actionEvent) {
        System.err.println("button");
    }

    private void textFieldHandler(ActionEvent actionEvent) {
        System.out.println("Textfield");
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}