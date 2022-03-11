module com.example.cscm94_gui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cscm94_gui to javafx.fxml;
    exports com.example.cscm94_gui;
}