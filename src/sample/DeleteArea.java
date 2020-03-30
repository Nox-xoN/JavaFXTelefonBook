package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.lang.reflect.Method;

public class DeleteArea {
    private final AnchorPane anchorPane = new AnchorPane();
    private final Button deleteButton = new Button("Delete");
    private TelefonBook telefonBook;

    private Method test = EntryArea::getSelectedEntries();

    DeleteArea(TelefonBook telefonBook)
    {
        this.telefonBook = telefonBook;

        AnchorPane.setRightAnchor(deleteButton, 10.0);
        AnchorPane.setBottomAnchor(deleteButton, 10.0);
        AnchorPane.setTopAnchor(deleteButton, 10.0);

        deleteButton.setOnAction(e -> deleteButtonClicked());

        anchorPane.getChildren().addAll(deleteButton);
    }

    public Node getPane() {
        return anchorPane;
    }

    public void deleteButtonClicked()
    {
        ObservableList test =  FXCollections.observableArrayList();

        telefonBook.getAddresses().removeAll();


//        telefonBook.getAddresses().removeAll(EntryArea::getSelectedEntries());


    }

    public void test()
    {

    }
}
