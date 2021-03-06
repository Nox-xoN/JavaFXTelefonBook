package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sample.data.TelefonBook;
import sample.data.TelefonEntry;
import sample.ui.DeleteArea;
import sample.ui.EntryArea;
import sample.ui.ExportWindow;
import sample.ui.SearchArea;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class Main extends Application {
    private List<TelefonBook> books = new ArrayList<>();
    private final TabPane tabPane = new TabPane();
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        BorderPane root = new BorderPane();
        root.setCenter(tabPane);

        loadBooksFromDirectory();

        primaryStage.setTitle("Telefonbook");
        primaryStage.setScene(new Scene(root, 650, 750));
        primaryStage.show();
    }

    private void loadBooksFromDirectory() {
        File folder = new File(".");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].getName().contains(".json")) {
                addTelefonBook(new TelefonBook(new ArrayList<>(), Paths.get(listOfFiles[i].getName())));
            }
        }
        if (books.isEmpty()) {
            addTelefonBook(new TelefonBook(new ArrayList<>()));
        }
    }

    private void addTelefonBook(TelefonBook telefonBook) {
        books.add(telefonBook);
        addTab(telefonBook);
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
                    FileChooser fC = new FileChooser();
                    fC.setInitialDirectory(new File("."));
                    fC.setInitialFileName("telefonbook.json");
                    fC.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Json Files", "*.json"));
                    File f = fC.showSaveDialog(primaryStage);
                    if (f != null) {
                        Path path = f.toPath();
                        books.get(tabPane.getSelectionModel().getSelectedIndex()).saveToFile(path);
                    }
                },
                () -> {
                    TelefonBook tB = new TelefonBook(new ArrayList<>());
                    books.add(tB);
                    addTab(tB);
                    tabPane.getSelectionModel().selectLast();
                },
                () -> {
                    ExportWindow exportWindow = new ExportWindow(books);

                    List<TelefonBook> selectedBooks = exportWindow.getSelectedBooks();
                    if (selectedBooks != null) {
                        for (int i = 0; i < selectedBooks.size(); i++) {
                            selectedBooks.get(i).getAllEntries().addAll(entryArea.getSelectedEntries());
                        }
                    }
                },
                () -> {
                    FileChooser fC = new FileChooser();
                    fC.setInitialDirectory(new File("."));
                    fC.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Json Files", "*.json"));
                    File f = fC.showOpenDialog(primaryStage);
                    if (f != null) {
                        Path path = f.toPath();
                        TelefonBook tB = new TelefonBook(new ArrayList<>());
                        books.add(tB);
                        tB.loadFromFile(path);
                        addTab(tB);
                        tabPane.getSelectionModel().selectLast();
                    }
                });

        tabRoot.setTop(searchArea.getPane());
        tabRoot.setCenter(entryArea.getPane());
        tabRoot.setBottom(deleteArea.getPane());
    }

    private void removeTab(TelefonBook telefonBook) {
        books.remove(telefonBook);
        if (books.isEmpty())
            addTelefonBook(new TelefonBook(new ArrayList<>()));
    }

    public static void main(String[] args) {
        launch(args);
        //credits https://github.com/Nox-xoN
    }
}
