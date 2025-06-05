package wk2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class ActivityController {
    @FXML
    private Label label;

    @FXML
    private void handleBigger(ActionEvent actionEvent) {
        resize(1.2);
    }

    @FXML
    private void handleSmaller(ActionEvent actionEvent) {
        resize(0.8);
    }

    private void resize(double magnification) {
        Font font = label.getFont();
        label.setFont(Font.font(font.getFamily(), magnification*font.getSize()));
    }
}
