package sample;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.beans.EventHandler;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class ExportWindow {
    private final Stage stage = new Stage();
    private final BorderPane root = new BorderPane();
    private final AnchorPane anchorPane = new AnchorPane();
    private final ScrollPane scrollPane = new ScrollPane();
    private final VBox vBox = new VBox();
    private final Button exportButton = new Button("Export Selected");

    private final List<CheckBox> boxes;
    private final List<TelefonBook> books;

    public ExportWindow(List<TelefonBook> telefonBooks) {
        books = telefonBooks;

        exportButton.setOnAction(e -> {
            stage.close();
        });

        AnchorPane.setLeftAnchor(exportButton, 10.0);
        AnchorPane.setRightAnchor(exportButton, 10.0);
        AnchorPane.setTopAnchor(exportButton, 10.0);
        AnchorPane.setBottomAnchor(exportButton, 10.0);

        root.getChildren().add(anchorPane);
        anchorPane.getChildren().add(scrollPane);
        scrollPane.setContent(vBox);
        root.setCenter(scrollPane);
        root.setBottom(exportButton);

        AnchorPane.setLeftAnchor(vBox, 10.0);
        AnchorPane.setRightAnchor(vBox, 10.0);
        AnchorPane.setTopAnchor(vBox, 10.0);
        AnchorPane.setBottomAnchor(vBox, 10.0);

        boxes = new ArrayList<>();
        for (int i = 0; i < telefonBooks.size(); i++) {
            AnchorPane aP = new AnchorPane();
            CheckBox cB =new CheckBox("Telefonbook " + (i + 1));
            boxes.add(cB);
            aP.getChildren().add(cB);

            AnchorPane.setLeftAnchor(cB, 10.0);
            AnchorPane.setRightAnchor(cB, 10.0);
            AnchorPane.setTopAnchor(cB, 10.0);
            AnchorPane.setBottomAnchor(cB, 10.0);
            vBox.getChildren().add(aP);
        }

        stage.setResizable(false);
        stage.setTitle("Export selected entries to...");
        stage.setScene(new Scene(root, 200, 300));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();

    }

    public List<TelefonBook> getSelectedBooks() {
        List<TelefonBook> selectedBooks = new ArrayList<>();

        for (int i = 0; i < boxes.size(); i++) {
            if (boxes.get(i).isSelected())
                selectedBooks.add(books.get(i));
        }
        return selectedBooks;
    }

}
