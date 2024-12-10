import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class MainAppController {

    @FXML
    private TableView<Task> taskTable; // Tabel untuk menampilkan daftar tugas
    @FXML
    private TableColumn<Task, String> titleCol, priorityCol, statusCol; // Kolom untuk judul, prioritas, dan status tugas
    @FXML
    private TableColumn<Task, LocalDate> dueDateCol; // Kolom untuk tanggal jatuh tempo
    @FXML
    private TextField titleField; // Field untuk memasukkan judul tugas
    @FXML
    private ComboBox<String> priorityBox; // ComboBox untuk memilih prioritas
    @FXML
    private DatePicker dueDatePicker; // DatePicker untuk memilih tanggal jatuh tempo

    private ObservableList<Task> taskList; // Daftar tugas yang dapat diamati

    @FXML
    public void initialize() {
        taskList = FXCollections.observableArrayList(TaskFileManager.loadTasks());


        titleCol.setCellValueFactory(new PropertyValueFactory<Task, String>("title"));
        priorityCol.setCellValueFactory(new PropertyValueFactory<Task, String>("Priority"));
        dueDateCol.setCellValueFactory(new PropertyValueFactory<Task, LocalDate>("DueDate"));
        statusCol.setCellValueFactory(new PropertyValueFactory<Task, String>("Status"));
        // TODO: konfigurasi kolom tabel untuk setiap atribut task
        // hint: gunakan setCellValueFactory dan PropertyValueFactory
        // TODO: konfigurasi lebar kolom agar lebih rapi    
        // hint: gunakan setPrefWidth
        titleCol.setPrefWidth(200);
        priorityCol.setPrefWidth(100);
        dueDateCol.setPrefWidth(100);
        statusCol.setPrefWidth(100);

        taskTable.setItems(taskList);

        // TODO: Tambahkan options prioritas ke ComboBox
        priorityBox.getItems().addAll("High", "Medium", "Low");
    }

    @FXML
    private void addTask() {
        try {
        
            if (titleField.getText().isEmpty() || priorityBox.getValue() == null || dueDatePicker.getValue() == null) {
                throw new MissingFieldException("Harap isi semua field");
                // TODO: Throw new MissingFieldException dengan pesan yang sesuai
            }

            if (dueDatePicker.getValue().isBefore(LocalDate.now())) {
                throw new InvalidDateException("Tanggal jatuh tempo tidak boleh sebelum hari ini");
                // TODO: Throw new InvalidDateException dengan pesan yang sesuai 
            }

            // TODO: Buat objek task baru dengan value dari field pada form
            // hint: gunakan getText() untuk TextField, getValue() untuk ComboBox, dan DatePicker, serta masukkan status "Incomplete" secara default
            Task task = new Task(
                    titleField.getText(),
                    priorityBox.getValue(),
                    dueDatePicker.getValue(),
                    "Incomplete"
            );
            

            // TODO: Tambahkan objek task yang telah dibuat ke taskList
            // hint: gunakan function bawaan dari ObservableList, yaitu add
            taskList.add(task);

            clearData();
            TaskFileManager.saveTasks(new ArrayList<>(taskList));
        }
        
        // Contoh catch MissingFieldException dan InvalidDateException
        catch (MissingFieldException | InvalidDateException e) {
            showError(e.getMessage());
        }

    }

    // TODO: hapus semua value dari field pada form
    // hint: gunakan function getSelectionModel().clearSelection() untuk ComboBox dan getEditor().clear() untuk DatePicker
    private void clearData(){
        titleField.clear();
        priorityBox.getSelectionModel().clearSelection();
        dueDatePicker.getEditor().clear();

    }

    @FXML
    private void deleteTask() {
        try {
    
            Task selected = taskTable.getSelectionModel().getSelectedItem();
            if (selected == null) {
                throw new TaskNotSelectedException("belum ada yang dipilih");
            } else if (selected.getStatus().equals("Complete")) {
                throw new TaskNotSelectedException("Tugas sudah selesai");
            }
                // TODO: Throw new TaskNotSelectedException dengan pesan yang sesuai 
                
        } catch  (TaskNotSelectedException e) {
                showError(e.getMessage());
                return;
            }
            taskList.remove(taskList.size() - 1);
            TaskFileManager.saveTasks(new ArrayList<>(taskList));
            taskTable.refresh();        
        // TODO: Catch TaskNotSelectedException dan panggil showError (Lihat contoh catch)        
    }

    @FXML
    private void markTaskComplete() {
        try {
            Task selected = taskTable.getSelectionModel().getSelectedItem();
            if (selected == null) {
                // TODO: Throw new TaskNotSelectedException dengan pesan yang sesuai 

            }
            // TODO: Ubah status task menjadi "Complete"
            // hint: gunakan function setStatus dari kelas Task

            taskTable.refresh();
            TaskFileManager.saveTasks(new ArrayList<>(taskList));
        } catch (Exception e) {
            showError(e.getMessage());
        }

        // TODO: Catch TaskNotSelectedException dan panggil showError sekali lagi
        

    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR, message, ButtonType.OK);
        alert.showAndWait();
    }

    // TODO: Buat kelas MissingFieldException
    public class MissingFieldException extends Exception {
        public MissingFieldException(String message) {
            super(message);
        }
    }
    
    // TODO: Buat kelas TaskNotSelectedException
    public class TaskNotSelectedException extends Exception {
        public TaskNotSelectedException(String message) {
            super(message);
        }

    }

    // TODO: Buat kelas InvalidDateException
    public class InvalidDateException extends Exception {
        public InvalidDateException(String message) {
            super(message);
        }

    }
    // TODO: Buat kelas MissingDateException
    public class MissingDateException extends Exception {
        public MissingDateException(String message) {
            super(message);
        }

    }
}