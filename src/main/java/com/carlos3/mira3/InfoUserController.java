package com.carlos3.mira3;

import com.carlos3.mira3.modelo.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

public class InfoUserController {
    @FXML
    public TextField inputAlbum;
    @FXML
    public TextField inputNombre;
    @FXML
    public TextField inputPais;
    @FXML
    public TextField inputCancion;

    public void EnviarAlbum(Usuario useractual) {
        if (useractual != null) {
            // Rellenamos los campos de la vista con los datos del álbum
            inputAlbum.setText(useractual.getNombre());
        } else {
            // Si por alguna razón llega null, mostramos un error
            Alert alert = new Alert(Alert.AlertType.ERROR,"Se ha producido un error al obtener el album", ButtonType.OK);
            alert.showAndWait();
        }
    }
    // Cierra completamente la aplicación
    public void handlerCerrarAplicacion(ActionEvent actionEvent) {
        System.exit(0);
    }
}
