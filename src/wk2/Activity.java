package wk2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Activity extends Application {
    private Label label;

    @Override
    public void start(Stage stage) throws Exception {
        VBox pane = new VBox();
        HBox buttons = new HBox();
        label = new Label("CSC1120 is fun");
        Button smaller = new Button("Smaller");
        Button bigger = new Button("Bigger");
        smaller.setOnAction(this::handleSmaller);
        bigger.setOnAction(this::handleBigger);
        buttons.getChildren().addAll(smaller, bigger);
        pane.getChildren().addAll(buttons, label);

        stage.setScene(new Scene(pane, 400, 300));
        stage.show();
    }

    private void handleBigger(ActionEvent actionEvent) {
        Font font = label.getFont();
        label.setFont(Font.font(font.getFamily(), 1.2*font.getSize()));
    }

    private void handleSmaller(ActionEvent actionEvent) {
        Font font = label.getFont();
        label.setFont(Font.font(font.getFamily(), 0.8*font.getSize()));
    }
}
