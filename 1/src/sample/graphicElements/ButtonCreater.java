package sample.graphicElements;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class ButtonCreater {

    public Button createButtonToCopyText(String text, GridPane gridPane, int inputText, int outputText){
        Button button=new Button(text);
        //для изменения раззмеров вместе со всем окном
        button.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        button.setAlignment(Pos.CENTER);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                handleButton(gridPane,inputText,outputText);
            }
        });

        return button;
    }

    private void handleButton(GridPane gridPane, int inputText, int outputText){
        TextField input=(TextField) gridPane.getChildren().get(inputText);
        TextField output=(TextField) gridPane.getChildren().get(outputText);

        String string=input.getText();
        output.setText(string);
    }

}
