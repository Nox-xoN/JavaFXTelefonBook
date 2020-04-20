package sample.ui;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import sample.data.TelefonBook;


public class SearchArea {
    private final AnchorPane anchorPane = new AnchorPane();
    private final TextField searchTextField = new TextField();

    public SearchArea(TelefonBook telefonBook) {
        AnchorPane.setLeftAnchor(searchTextField, 10.0);
        AnchorPane.setTopAnchor(searchTextField, 10.0);
        AnchorPane.setRightAnchor(searchTextField, 10.0);
        AnchorPane.setBottomAnchor(searchTextField, 10.0);

        searchTextField.textProperty().addListener((observable, oldValue, newValue) ->
        {
            telefonBook.getFilteredEntries().setPredicate(entry -> {
                //if filter text is empty display all entries
                if (searchTextField.textProperty() == null || searchTextField.getText().isEmpty())
                    return true;

                String lowerCaseFilter = searchTextField.getText().toLowerCase();

                if (entry.getFirstName().toLowerCase().indexOf(lowerCaseFilter) != -1)
                    return true;
                else if (entry.getLastName().toLowerCase().indexOf(lowerCaseFilter) != -1)
                    return true;
                else if (entry.getNumber().toLowerCase().indexOf(lowerCaseFilter) != -1)
                    return true;
                else
                    return false; //No Match
            });
        });

        anchorPane.getChildren().addAll(searchTextField);
    }

    public Node getPane() {
        return anchorPane;
    }
}
