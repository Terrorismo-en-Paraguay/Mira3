package com.carlos3.mira3;

import com.carlos3.mira3.modelo.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class InfoUserController {
    @FXML
    public Label inputlogin;
    @FXML
    public Label inputNombre;
    @FXML
    public Label inputapellido;
    @FXML
    public Label inputrole;

    public void setUsuario(Usuario useractual) {
        if (useractual != null) {
            // Rellenamos los campos de la vista con los datos del álbum
            inputNombre.setText(useractual.getNombre());
            inputapellido.setText(useractual.getApellidos());
            inputlogin.setText(useractual.getLogin());
            inputrole.setText(useractual.getRole());
        } else {
            // Si por alguna razón llega null, mostramos un error
            Alert alert = new Alert(Alert.AlertType.ERROR, "Se ha producido un error al obtener el usuario",
                    ButtonType.OK);
            alert.showAndWait();
        }
    }

    // Cierra completamente la aplicación
    public void handlerCerrarAplicacion(ActionEvent actionEvent) {
        System.exit(0);
    }
}
