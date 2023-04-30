module com.example.project2 {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.prefs;

    opens com.example.project2 to javafx.fxml;
    exports com.example.project2;
}