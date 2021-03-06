package sample.programStarter;

import javafx.application.Application;
import javafx.stage.Stage;
import sample.graphicElements.WindowCreator;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        new WindowCreator().display(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
