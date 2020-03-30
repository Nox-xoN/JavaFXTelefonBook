package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application {

    TelefonBook telefonBook =  new TelefonBook();

    @Override
    public void start(Stage primaryStage) throws Exception{

        BorderPane root = new BorderPane();

        SearchArea searchArea = new SearchArea();

        telefonBook.addEntry(new TelefonEntry("Marco", "Lenz", "4908234"));
        telefonBook.addEntry(new TelefonEntry("sefsef", "L3r3enz", "25235"));
        telefonBook.addEntry(new TelefonEntry("efeef", "Le343nz", "7767"));
        telefonBook.addEntry(new TelefonEntry("gseg", "eee", "222345"));
        telefonBook.addEntry(new TelefonEntry("sgshhh", "Lefsfenz", "34534"));

        EntryArea entryArea = new EntryArea(telefonBook.getAddresses());

        DeleteArea deleteArea = new DeleteArea(telefonBook);



        root.setTop(searchArea.getPane());
        root.setCenter(entryArea.getAnchorPane());
        root.setBottom(deleteArea.getPane());

        primaryStage.setTitle("Telefonbook");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();








//        primaryStage.setTitle("Telefonbook");
//
//        AnchorPane rootAnchor = new AnchorPane();
//        rootAnchor.maxHeight(Double.NEGATIVE_INFINITY);
//        rootAnchor.maxWidth(Double.NEGATIVE_INFINITY);
//        rootAnchor.minHeight(Double.NEGATIVE_INFINITY);
//        rootAnchor.minWidth(Double.NEGATIVE_INFINITY);
//        rootAnchor.prefHeight(718);
//        rootAnchor.prefWidth(416);
//
//
//        VBox vBox0 = new VBox();
//        vBox0.prefHeight(400);
//        vBox0.prefWidth(600);
//
//        AnchorPane.setBottomAnchor(vBox0,0.0);
//        AnchorPane.setTopAnchor(vBox0,0.0);
//        AnchorPane.setRightAnchor(vBox0,0.0);
//        AnchorPane.setLeftAnchor(vBox0,0.0);
//        rootAnchor.getChildren().add(vBox0);
//
//
//        //AnchorPane1
//        AnchorPane anchorPane0_0 = new AnchorPane();
//        anchorPane0_0.prefHeight(35);
//        anchorPane0_0.prefWidth(416);
//        vBox0.getChildren().add(anchorPane0_0);
//
//        searchTextField.setOnKeyTyped(e -> searchBtnClicked(searchTextField.getText()));
//        searchTextField.prefWidth(326);
//        searchTextField.prefHeight(25);
//        AnchorPane.setBottomAnchor(searchTextField,0.0);
//        AnchorPane.setTopAnchor(searchTextField,5.0);
//        AnchorPane.setRightAnchor(searchTextField,95.0);
//        AnchorPane.setLeftAnchor(searchTextField,5.0);
//        anchorPane0_0.getChildren().add(searchTextField);
//
//
//
//        searchBtn.setOnAction(e -> searchBtnClicked(searchTextField.getText()));
//        searchBtn.setMnemonicParsing(false);
//        searchBtn.prefWidth(85);
//        searchBtn.prefHeight(25);
//        AnchorPane.setBottomAnchor(searchBtn,0.0);
//        AnchorPane.setTopAnchor(searchBtn,5.0);
//        AnchorPane.setRightAnchor(searchBtn,5.0);
//        anchorPane0_0.getChildren().add(searchBtn);
//
//
//        //AnchorPane2
//        AnchorPane anchorPane0_1 = new AnchorPane();
//        anchorPane0_1.prefHeight(1023);
//        anchorPane0_1.prefWidth(416);
//        vBox0.getChildren().add(anchorPane0_1);
//
//
//
//
//        TableView.TableViewSelectionModel selectionModel = table.getSelectionModel();
//        selectionModel.setSelectionMode(SelectionMode.MULTIPLE);
//        table.prefHeight(200);
//        AnchorPane.setBottomAnchor(table,5.0);
//        AnchorPane.setTopAnchor(table,5.0);
//        AnchorPane.setRightAnchor(table,5.0);
//        AnchorPane.setLeftAnchor(table,5.0);
//
//        firstNameCol.setCellValueFactory(new PropertyValueFactory<TelefonEntry, String>("firstName"));
//        lastNameCol.setCellValueFactory(new PropertyValueFactory<TelefonEntry, String>("lastName"));
//        numberCol.setCellValueFactory(new PropertyValueFactory<TelefonEntry, String>("number"));
//
//        firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
//        lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
//        numberCol.setCellFactory(TextFieldTableCell.forTableColumn());
//
//        firstNameCol.setOnEditCommit(event -> { editTelefonEntry(event.getRowValue()); });
//        lastNameCol.setOnEditCommit(event -> { editTelefonEntry(event.getRowValue()); });
//        numberCol.setOnEditCommit(event -> { editTelefonEntry(event.getRowValue()); });
//
//        firstNameCol.setPrefWidth(75);
//        lastNameCol.setPrefWidth(75);
//        numberCol.setPrefWidth(75);
//
//
//        table.setEditable(true);
//
//
//        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
//        table.getColumns().addAll(firstNameCol, lastNameCol, numberCol);
//
//
//
//        table.getItems().add(new TelefonEntry("", "",""));
//
//
//        searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {
//            filteredData.setPredicate(entry -> { // If filter text is empty, display all entities.
//                if (newValue == null || newValue.isEmpty()) {
//                    return true;
//                }
//
//                // Compare first name and last name of every person with filter text.
//                String lowerCaseFilter = newValue.toLowerCase();
//
//                if (entry.getFirstName().toLowerCase().contains(lowerCaseFilter)) {
//                    return true; // Filter matches first name.
//                } else if (entry.getLastName().toLowerCase().contains(lowerCaseFilter)) {
//                    return true; // Filter matches last name.
//                } else if (entry.getNumber().toLowerCase().contains(lowerCaseFilter)) {
//                    return true; // Filter matches last name.
//                }
//                return false; // Does not match.
//            });
//        });
//
//        sortedData.comparatorProperty().bind(table.comparatorProperty());
//        table.setItems(sortedData);
//
//
//
//
//
//
//        anchorPane0_1.getChildren().add(table);
//
//
//        //AnchorPane3
//        AnchorPane anchorPane0_2 = new AnchorPane();
//        vBox0.getChildren().add(anchorPane0_2);
//
//
//        addBtn.setOnAction(e -> addBtnClicked());
//        addBtn.setMnemonicParsing(false);
//        AnchorPane.setBottomAnchor(addBtn,5.0);
//        AnchorPane.setLeftAnchor(addBtn,5.0);
//        anchorPane0_2.getChildren().add(addBtn);
//
//        deleteBtn.setOnAction(e -> deleteBtnClicked());
//        deleteBtn.setMnemonicParsing(false);
//        AnchorPane.setBottomAnchor(deleteBtn,5.0);
//        AnchorPane.setRightAnchor(deleteBtn,5.0);
//        anchorPane0_2.getChildren().add(deleteBtn);
//
//
//        Scene scene = new Scene(rootAnchor);
//        primaryStage.setScene(scene);
//        primaryStage.show();
    }

    private void addBtnClicked() {
//        table.getItems().add(new TelefonEntry("","",""));
    }

    public void searchBtnClicked(String s)
    {
//        System.out.println(s);
//        filteredEntries.setPredicate(em);
    }

//    public void deleteBtnClicked()
//    {
//        table.getItems().removeAll(table.getSelectionModel().getSelectedItems());
//    }

    public void editTelefonEntry(TelefonEntry entry)
    {
//        System.out.println("TEST");
//        table.getItems().add(new TelefonEntry("", "",""));
    }

    public void addTelefonEntry()
    {

    }


    public static void main(String[] args) {
        launch(args);
    }

}
