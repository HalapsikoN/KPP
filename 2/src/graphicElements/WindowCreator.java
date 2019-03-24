package graphicElements;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class WindowCreator {

    public void display(Stage primaryStage){
        primaryStage.setResizable(false);
        BorderPane root = new BorderPane();
        Scene scene=new Scene(root, 1000, 700);
        primaryStage.setTitle("University");

        GridPaneCreator myGridPane= new GridPaneCreator();
        GridPane gridPane=myGridPane.createGridPane();

        Label label=new LabelCreator().createLabel("Subjects name: ");
        gridPane.add(label,0,0);
        TextField textField=new TextFieldCreator().createTextField();
        gridPane.add(textField,1,0);

        label=new LabelCreator().createLabel("Lectures: ");
        gridPane.add(label,0,1);
        textField=new TextFieldCreator().createTextField();
        gridPane.add(textField,1,1);

        label=new LabelCreator().createLabel("Teachers: ");
        gridPane.add(label,0,2);
        textField=new TextFieldCreator().createTextField();
        gridPane.add(textField,1,2);

        /*label=new LabelCreator().createLabel("Subjects name: ");
        gridPane.add(label,0,3);
        textField=new TextFieldCreator().createTextField();
        gridPane.add(textField,1,3);*/

        label=new LabelCreator().createLabel("Students: ");
        gridPane.add(label,0,3);
        textField=new TextFieldCreator().createTextField();
        gridPane.add(textField,1,3);

        Button button=new ButtonCreator().createButtonToCopyText("Render", gridPane);
        gridPane.add(button, 0, 4,2,1);

        for (int i=6;i<20;++i) {
            for(int j=0;j<2;++j) {
                label = new LabelCreator().createLabel("");
                gridPane.add(label, j, i);
            }
        }

        root.setCenter(gridPane);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
