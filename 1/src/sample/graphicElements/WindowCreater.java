package sample.graphicElements;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class WindowCreater {

    public void display(Stage primaryStage){
        BorderPane root = new BorderPane();
        Scene scene=new Scene(root, 400, 80);
        primaryStage.setTitle("Copy buttons");

        //поле
        GridPaneCreater myGridPane=new GridPaneCreater();
        GridPane gridPane=myGridPane.createGridPane(3);

        Label label=new LabelCreater().createLabel("1");
        gridPane.add(label,0,0);

        label=new LabelCreater().createLabel("2");
        gridPane.add(label,1,0);

        label=new LabelCreater().createLabel("3");
        gridPane.add(label,2,0);

        TextField textField=new TextFieldCreater().createTextField();
        gridPane.add(textField, 0, 1);

        textField=new TextFieldCreater().createTextField();
        gridPane.add(textField, 1, 1);

        textField=new TextFieldCreater().createTextField();
        gridPane.add(textField, 2, 1);

        Button button=new ButtonCreater().createButtonToCopyText("Copy 1 to 2", gridPane,3,4);
        gridPane.add(button, 0, 2);

        button=new ButtonCreater().createButtonToCopyText("Copy 2 to 3",gridPane,4,5);
        gridPane.add(button, 1, 2);

        root.setCenter(gridPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
