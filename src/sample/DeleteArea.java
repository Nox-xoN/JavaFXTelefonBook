package sample;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;


public class DeleteArea {
    private final AnchorPane anchorPane = new AnchorPane();
    private final Button deleteButton = new Button("Delete");
    private final Button addEntryButton = new Button("Add Entry");
    private final Button addBookButton = new Button("Add Book");
    private final Button exportButton = new Button("Export");
    private final Button saveButton = new Button("Save");

    public DeleteArea(Runnable deleteEntry, Runnable addEntry, Runnable save, Runnable addBook, Runnable exportStart) {
        AnchorPane.setRightAnchor(deleteButton, 10.0);
        AnchorPane.setBottomAnchor(deleteButton, 10.0);
        AnchorPane.setTopAnchor(deleteButton, 10.0);

        AnchorPane.setLeftAnchor(addEntryButton, 10.0);
        AnchorPane.setBottomAnchor(addEntryButton, 10.0);
        AnchorPane.setTopAnchor(addEntryButton, 10.0);

        AnchorPane.setLeftAnchor(addBookButton, 95.0);
        AnchorPane.setBottomAnchor(addBookButton, 10.0);
        AnchorPane.setTopAnchor(addBookButton, 10.0);

        AnchorPane.setLeftAnchor(exportButton, 180.0);
        AnchorPane.setBottomAnchor(exportButton, 10.0);
        AnchorPane.setTopAnchor(exportButton, 10.0);

        AnchorPane.setRightAnchor(saveButton, 75.0);
        AnchorPane.setBottomAnchor(saveButton, 10.0);
        AnchorPane.setTopAnchor(saveButton, 10.0);

        deleteButton.setOnAction(e -> {
            deleteEntry.run();
        });

        addEntryButton.setOnAction(e -> {
            addEntry.run();
        });

        saveButton.setOnAction(e -> {
            save.run();
        });

        addBookButton.setOnAction(e-> {
            addBook.run();
        });

        exportButton.setOnAction(e-> {
            exportStart.run();
        });

        anchorPane.getChildren().addAll(deleteButton, addEntryButton, saveButton, addBookButton, exportButton);
    }

    public Node getPane() {
        return anchorPane;
    }
}
