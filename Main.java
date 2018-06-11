package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    static final int DEFAULT_WIDTH = 800;
    static final int DEFAULT_HEIGHT = 600;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        primaryStage.setTitle("Mamba");
        primaryStage.setScene(new Scene(root, DEFAULT_WIDTH, DEFAULT_HEIGHT));
        primaryStage.getIcons().add(new Image("file:spiderDOWN1.png"));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}
