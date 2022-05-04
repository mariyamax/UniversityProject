module com.example.myapplication {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.myapplication to javafx.fxml;
    exports com.example.myapplication;
}