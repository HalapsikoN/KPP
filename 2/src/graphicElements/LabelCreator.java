package graphicElements;

import javafx.geometry.Pos;
import javafx.scene.control.Label;

public class LabelCreator {
    public Label createLabel(String str){
        Label label=new Label(str);
        //для изменения раззмеров вместе со всем окном
        label.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        label.setAlignment(Pos.CENTER);
        return label;
    }
}
