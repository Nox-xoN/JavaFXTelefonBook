package sample.ui;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;


public class DeleteArea {
    private final AnchorPane anchorPane = new AnchorPane();
    private final HBox hBox = new HBox(10);

    private final Button deleteButton = new Button("Delete Selected Entry");
    private final Button addEntryButton = new Button("Add Entry");
    private final Button addBookButton = new Button("Add Book");
    private final Button exportButton = new Button("Export Selected");
    private final Button saveButton = new Button("Save to File");

    public DeleteArea(Runnable deleteEntry, Runnable addEntry, Runnable save, Runnable addBook, Runnable exportStart) {
        AnchorPane.setLeftAnchor(hBox, 10.0);
        AnchorPane.setRightAnchor(hBox, 10.0);
        AnchorPane.setBottomAnchor(hBox, 10.0);
        AnchorPane.setTopAnchor(hBox, 10.0);

        deleteButton.setOnAction(e -> {
            deleteEntry.run();
        });

        addEntryButton.setOnAction(e -> {
            addEntry.run();
        });

        saveButton.setOnAction(e -> {
            save.run();
        });

        addBookButton.setOnAction(e -> {
            addBook.run();
        });

        exportButton.setOnAction(e -> {
            exportStart.run();
        });

        anchorPane.getChildren().add(hBox);
        hBox.getChildren().addAll(addEntryButton, deleteButton, exportButton, saveButton, addBookButton);

    }

    public Node getPane() {
        return anchorPane;
    }
}
