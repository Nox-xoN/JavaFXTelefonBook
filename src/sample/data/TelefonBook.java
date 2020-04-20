package sample.data;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class TelefonBook {
    private ObservableList<TelefonEntry> oTelefonNumbers;
    private FilteredList<TelefonEntry> fTelefonNumbers;
    private SortedList<TelefonEntry> sTelefonNumbers;


    public TelefonBook(List<TelefonEntry> entries) {
        this.oTelefonNumbers = FXCollections.observableArrayList(entries);
        this.fTelefonNumbers = new FilteredList<>(oTelefonNumbers, entry -> true);
        this.sTelefonNumbers = new SortedList<>(fTelefonNumbers);
    }

    public TelefonBook(List<TelefonEntry> entries, Path pathToSaveFile) {
        this.oTelefonNumbers = FXCollections.observableArrayList(entries);
        this.fTelefonNumbers = new FilteredList<>(oTelefonNumbers, entry -> true);
        this.sTelefonNumbers = new SortedList<>(fTelefonNumbers);

        loadFromFile(pathToSaveFile);
    }

    public ObservableList<TelefonEntry> getAllEntries() {
        return oTelefonNumbers;
    }

    public FilteredList<TelefonEntry> getFilteredEntries() {
        return fTelefonNumbers;
    }

    public SortedList<TelefonEntry> getSortedEntries() {
        return sTelefonNumbers;
    }

    public void saveToFile(Path path) {
        JsonFactory factory = new JsonFactory();
        try (OutputStream os = Files.newOutputStream(path);
             JsonGenerator jg = factory.createGenerator(os)) {

            jg.writeStartObject();
            jg.writeArrayFieldStart("data");
            for (TelefonEntry entry : oTelefonNumbers) {
                jg.writeStartObject();
                jg.writeStringField("firstName", entry.getFirstName());
                jg.writeStringField("lastName", entry.getLastName());
                jg.writeStringField("number", entry.getNumber());
                jg.writeEndObject();
            }
            jg.writeEndArray();
            jg.writeEndObject();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile(Path pathToSaveFile) {
        try (InputStream is = Files.newInputStream(pathToSaveFile)) {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(is);
            JsonNode items = root.get("data");
            for (JsonNode e : items) {
                oTelefonNumbers.add((new TelefonEntry(
                        e.get("firstName").asText(),
                        e.get("lastName").asText(),
                        e.get("number").asText())));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
