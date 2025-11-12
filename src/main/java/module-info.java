module com.carlos3.mira3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.desktop;


    opens com.carlos3.mira3;
    exports com.carlos3.mira3;
    exports com.carlos3.mira3.modelo;
    opens com.carlos3.mira3.modelo;
}