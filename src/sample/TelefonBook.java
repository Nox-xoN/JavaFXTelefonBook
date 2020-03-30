package sample;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;


public class TelefonBook {
    private ObservableList<TelefonEntry> oTelefonNumbers = FXCollections.observableArrayList();



    public ObservableList<TelefonEntry> getAddresses()
    {
        return oTelefonNumbers;
    }

    public List<TelefonEntry> search(String searchTerm)
    {

        return null;
    }

    public void addEntry(TelefonEntry telefonEntry)
    {
        oTelefonNumbers.add(telefonEntry);
    }





}
