package sample;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.nio.file.Paths;
import java.util.ArrayList;


public class Main extends Application {
    
    TelefonBook telefonBook = new TelefonBook(new ArrayList<>(), Paths.get("data.json"));

    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane root = new BorderPane();

        SearchArea searchArea = new SearchArea(telefonBook);
        EntryArea entryArea = new EntryArea(telefonBook);
        DeleteArea deleteArea = new DeleteArea(
                () -> {
                    telefonBook.getAllEntries().removeAll(entryArea.getSelectedEntries());
                },

                () -> {
                    telefonBook.getAllEntries().add(new TelefonEntry("first name", "last name", "number"));
                },

                () -> {
                    telefonBook.saveToFile();
                }
        );

        root.setTop(searchArea.getPane());
        root.setCenter(entryArea.getPane());
        root.setBottom(deleteArea.getPane());

        primaryStage.setTitle("Telefonbook");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void stop(){
        System.out.println("Stage is closing");
        // Save file
    }
}
