module com.example.projektiknk {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;

opens Models to javafx.base;
    opens com.example.projektiknk to javafx.fxml;
    exports com.example.projektiknk;
    exports com.example.projektiknk.Controller;
    opens com.example.projektiknk.Controller to javafx.fxml;
}