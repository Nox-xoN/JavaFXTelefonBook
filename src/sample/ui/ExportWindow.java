package sample.ui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.data.TelefonBook;

import java.util.ArrayList;
import java.util.List;


public class ExportWindow {
    private final Stage stage;
    private final BorderPane root;
    private final AnchorPane anchorPane;
    private final ScrollPane scrollPane;
    private final VBox vBox;
    private final Button exportButton;
    private final List<CheckBox> boxes;
    private final List<TelefonBook> books;


    public ExportWindow(List<TelefonBook> telefonBooks) {
        stage = new Stage();
        root = new BorderPane();
        anchorPane = new AnchorPane();
        scrollPane = new ScrollPane();
        vBox = new VBox();
        boxes = new ArrayList<>();
        exportButton = new Button("Export Selected");
        books = telefonBooks;

        AnchorPane.setLeftAnchor(exportButton, 10.0);
        AnchorPane.setRightAnchor(exportButton, 10.0);
        AnchorPane.setTopAnchor(exportButton, 10.0);
        AnchorPane.setBottomAnchor(exportButton, 10.0);
        AnchorPane.setLeftAnchor(vBox, 10.0);
        AnchorPane.setRightAnchor(vBox, 10.0);
        AnchorPane.setTopAnchor(vBox, 10.0);
        AnchorPane.setBottomAnchor(vBox, 10.0);

        exportButton.setOnAction(e -> {
            stage.close();
        });

        for (int i = 0; i < telefonBooks.size(); i++) {
            AnchorPane aP = new AnchorPane();
            CheckBox cB = new CheckBox("Telefonbook " + (i + 1));
            boxes.add(cB);
            aP.getChildren().add(cB);

            AnchorPane.setLeftAnchor(cB, 10.0);
            AnchorPane.setRightAnchor(cB, 10.0);
            AnchorPane.setTopAnchor(cB, 10.0);
            AnchorPane.setBottomAnchor(cB, 10.0);
            vBox.getChildren().add(aP);
        }

        root.getChildren().add(anchorPane);
        anchorPane.getChildren().add(scrollPane);
        scrollPane.setContent(vBox);
        root.setCenter(scrollPane);
        root.setBottom(exportButton);

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
