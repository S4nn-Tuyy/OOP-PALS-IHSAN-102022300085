module bmt {
    requires javafx.controls;
    requires javafx.fxml;

    opens bmt to javafx.fxml;
    exports bmt;
}
