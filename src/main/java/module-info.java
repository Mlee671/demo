module com.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens com.example to javafx.fxml;
    opens com.example.controllers to javafx.fxml;
    exports com.example;
}
