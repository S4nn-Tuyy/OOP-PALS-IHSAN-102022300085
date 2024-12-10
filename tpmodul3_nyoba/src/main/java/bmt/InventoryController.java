package bmt;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;



public class InventoryController {
    @FXML
    private TableView<Album> albumTable;
    @FXML
    private TableColumn<Album, String> nameColumn;
    @FXML
    private TableColumn<Album, String> artistColumn;
    @FXML
    private TableColumn<Album, Integer> totalColumn;
    @FXML
    private TableColumn<Album, Integer> availableColumn;
    @FXML
    private TextField nameField;
    @FXML
    private TextField artistField;
    @FXML
    private TextField totalField;
    @FXML
    private TextField availableField;

    private final ObservableList<Album> albumList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        nameColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getAlbumName()));
        artistColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getArtist()));
        totalColumn.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getTotal()).asObject());
        availableColumn.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getAvailable()).asObject());

        albumTable.setItems(albumList);
    }

    @FXML
    @SuppressWarnings("unused")
    private void handleAdd() {
        try {
            String name = nameField.getText();
            String artist = artistField.getText();
            int total = Integer.parseInt(totalField.getText());
            int available = Integer.parseInt(availableField.getText());

            albumList.add(new Album(name, artist, total, available));
            showAlert(Alert.AlertType.INFORMATION, "Berhasil", "Album berhasil di tambahkan");
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Error", "invalid input. Please enter correct values.");
        }
    }

    @FXML
    @SuppressWarnings("unused")
    private void handleUpdate() {
        Album selectedAlbum = albumTable.getSelectionModel().getSelectedItem();
        if (selectedAlbum != null) {
            try {
                selectedAlbum.setAlbumName(nameField.getText());
                selectedAlbum.setArtist(artistField.getText());
                selectedAlbum.setTotal(Integer.parseInt(totalField.getText()));
                selectedAlbum.setAvailable(Integer.parseInt(availableField.getText()));
                albumTable.refresh();
                showAlert(Alert.AlertType.INFORMATION, "Success", "Album updated successfully.");
            } catch (NumberFormatException e) {
                showAlert(Alert.AlertType.ERROR, "Error", "Invalid input. Please enter correct values.");
            }
        } else {
            showAlert(Alert.AlertType.WARNING, "Warning", "No album selected.");
        }
    }

    @FXML
    @SuppressWarnings("unused")
    private void handleDelete() {
        Album selectedAlbum = albumTable.getSelectionModel().getSelectedItem();
        if (selectedAlbum != null) {
            albumList.remove(selectedAlbum);
            showAlert(Alert.AlertType.INFORMATION, "Success", "Album deleted successfully.");
        } else {
            showAlert(Alert.AlertType.WARNING, "Warning", "No album selected.");
        }
    }

    @FXML
    @SuppressWarnings("unused")
    private void handleRent() {
        Album selectedAlbum = albumTable.getSelectionModel().getSelectedItem();
        if (selectedAlbum != null) {
            try {
                selectedAlbum.rentAlbum();
                albumTable.refresh();
                showAlert(Alert.AlertType.INFORMATION, "Berhasil", "Album.");
            } catch (IllegalStateException e) {
                showAlert(Alert.AlertType.ERROR, "Error", e.getMessage());
            }
        } else {
            showAlert(Alert.AlertType.WARNING, "Warning", "Tidak ada album yang terpilih.");
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    @SuppressWarnings("unused")
    private void handleMouseClicked(MouseEvent event) {
        Album selectedAlbum = albumTable.getSelectionModel().getSelectedItem();
        if (selectedAlbum != null) {
            nameField.setText(selectedAlbum.getAlbumName());
            artistField.setText(selectedAlbum.getArtist());
            totalField.setText(String.valueOf(selectedAlbum.getTotal()));
            availableField.setText(String.valueOf(selectedAlbum.getAvailable()));
        }
    }
}