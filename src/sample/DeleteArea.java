package sample;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;


public class DeleteArea {
    private final AnchorPane anchorPane = new AnchorPane();
    private final Button deleteButton = new Button("Delete");
    private final Button addButton = new Button("Add");
    private final Button saveButton = new Button("Save");

    DeleteArea(Runnable deleteEntry, Runnable addEntry, Runnable save) {
        AnchorPane.setRightAnchor(deleteButton, 10.0);
        AnchorPane.setBottomAnchor(deleteButton, 10.0);
        AnchorPane.setTopAnchor(deleteButton, 10.0);

        AnchorPane.setLeftAnchor(addButton, 10.0);
        AnchorPane.setBottomAnchor(addButton, 10.0);
        AnchorPane.setTopAnchor(addButton, 10.0);

        AnchorPane.setRightAnchor(saveButton, 80.0);
        AnchorPane.setBottomAnchor(saveButton, 10.0);
        AnchorPane.setTopAnchor(saveButton, 10.0);

        deleteButton.setOnAction(e -> {
            deleteEntry.run();
        });

        addButton.setOnAction(e -> {
            addEntry.run();
        });

        saveButton.setOnAction(e -> {
            save.run();
        });

        anchorPane.getChildren().addAll(deleteButton, addButton, saveButton);
    }

    public Node getPane() {
        return anchorPane;
    }
}
