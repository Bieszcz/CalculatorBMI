module com.example.hhhui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.hhhui to javafx.fxml;
    exports com.example.hhhui;
}