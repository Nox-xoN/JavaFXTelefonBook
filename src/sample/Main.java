package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class Main extends Application {
    private List<TelefonBook> books = new ArrayList<>();
    private final TabPane tabPane = new TabPane();

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        root.setCenter(tabPane);

        loadBooks();

        primaryStage.setTitle("Telefonbook");
        primaryStage.setScene(new Scene(root, 500, 600));
        primaryStage.show();
    }

    private void loadBooks() {
        File folder = new File(".");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].getName().contains(".json")) {
                TelefonBook tB = new TelefonBook(new ArrayList<>(), Paths.get(listOfFiles[i].getName()));
                books.add(tB);
                addTab(tB);
            }
        }
    }

    private void addTab(TelefonBook telefonBook) {
        BorderPane tabRoot = new BorderPane();

        Tab tab = new Tab("Telefonbook " + books.size());
        tabPane.getTabs().add(tab);
        tab.setContent(tabRoot);
        tab.setOnClosed(e -> removeTab(telefonBook));

        EntryArea entryArea = new EntryArea(telefonBook);
        SearchArea searchArea = new SearchArea(telefonBook);
        DeleteArea deleteArea = new DeleteArea(
                () -> {
                    books.get(tabPane.getSelectionModel().getSelectedIndex()).getAllEntries().removeAll(entryArea.getSelectedEntries());
                },
                () -> {
                    books.get(tabPane.getSelectionModel().getSelectedIndex()).getAllEntries().add(new TelefonEntry("first name", "last name", "number"));
                },
                () -> {
                    books.get(tabPane.getSelectionModel().getSelectedIndex()).saveToFile(tabPane.getSelectionModel().getSelectedIndex());
                },
                () -> {
                    TelefonBook tB = new TelefonBook(new ArrayList<>(), Paths.get("data" + (books.size() + 1) + ".json"));
                    books.add(tB);
                    addTab(tB);
                },
                () -> {
                    ExportWindow exportWindow = new ExportWindow(books);

                    List<TelefonBook> selectedBooks = exportWindow.getSelectedBooks();
                    for(int i = 0; i < selectedBooks.size(); i++)
                    {
                        selectedBooks.get(i).getAllEntries().addAll(entryArea.getSelectedEntries());
                    }
                });


        tabRoot.setTop(searchArea.getPane());
        tabRoot.setCenter(entryArea.getPane());
        tabRoot.setBottom(deleteArea.getPane());
    }

    private void removeTab(TelefonBook telefonBook) {
        books.remove(telefonBook);
    }

    private void exportEntries(List<TelefonBook> books) {

    }

    public static void main(String[] args) {
        launch(args);
    }
}
