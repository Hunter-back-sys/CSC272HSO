module com.example.assignment_2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.assignment_2 to javafx.fxml;
    exports com.example.assignment_2;
}