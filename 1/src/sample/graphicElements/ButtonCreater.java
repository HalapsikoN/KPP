package sample.graphicElements;

import javafx.geometry.Pos;
import javafx.scene.control.Button;

public class ButtonCreater {

    public Button createButton(String str){
        Button button = new Button(str);
        //для изменения раззмеров вместе со всем окном
        button.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        button.setAlignment(Pos.CENTER);

        return button;
    }

}
