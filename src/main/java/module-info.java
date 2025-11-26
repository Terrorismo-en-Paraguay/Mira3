module com.carlos3.mira3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.desktop;
    requires javafx.base;
    requires javafx.graphics;


    opens com.carlos3.mira3;
    exports com.carlos3.mira3;
    exports com.carlos3.mira3.modelo;
    opens com.carlos3.mira3.modelo;
}