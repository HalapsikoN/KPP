package graphicElements;

import javafx.geometry.Pos;
import javafx.scene.control.TextField;

public class TextFieldCreator {
    public TextField createTextField() {
        TextField textField = new TextField();
        //для изменения раззмеров вместе со всем окном
        textField.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        textField.setAlignment(Pos.CENTER);
        return textField;
    }
}
