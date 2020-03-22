package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    Button searchBtn;
    TextField searchTF;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Telefonbook");
        primaryStage.setScene(new Scene(root, 300, 275));

//        searchBtn = new Button();
//        searchBtn.setText("Suchen");
//
//        searchTF = new TextField();
//        primaryStage.show();
//
//        StackPane layout = new StackPane();
//        layout.getChildren().add(searchBtn);
//
//        Scene scene = new Scene(layout, 300, 250);
//        primaryStage.setScene(scene);





    }


    public static void main(String[] args) {
        launch(args);
    }
}
