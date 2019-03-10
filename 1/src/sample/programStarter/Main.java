package sample.programStarter;

import javafx.application.Application;
import javafx.stage.Stage;
import sample.graphicElements.WindowCreater;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        new WindowCreater().display(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
