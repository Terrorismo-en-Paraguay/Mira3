package com.carlos3.mira3;

import com.carlos3.mira3.modelo.Usuario;
import com.carlos3.mira3.InfoUserController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private Button btnIniciarSesion;
    @FXML
    private TextField inputLogin;
    @FXML
    private TextField inputPassword;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // No initialization needed for now
    }

    @FXML
    public void handlerIniciarSesion(ActionEvent actionEvent) {
        String login = inputLogin.getText();
        String password = inputPassword.getText();

        MainApp.usuario_actual = null;

        for (Usuario a : MainApp.listaUsuarios) {
            if (a.getLogin().equalsIgnoreCase(login) && a.getPassword().equalsIgnoreCase(password)) {
                MainApp.usuario_actual = a;
                break;
            }
        }

        if (MainApp.usuario_actual == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "El nombre del usuario o contraseña no son correctos",
                    ButtonType.OK);
            alert.showAndWait();
            inputLogin.setText("");
            inputPassword.setText("");
        } else {
            Stage ventana = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            cambiarEscena(ventana);
        }
    }

    private void cambiarEscena(Stage ventana) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("info_user.fxml"));
            Scene escena = new Scene(fxmlLoader.load());
            InfoUserController controlador = fxmlLoader.getController();
            controlador.setUsuario(MainApp.usuario_actual);
            ventana.hide();
            ventana.setScene(escena);
            ventana.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void handlerCerrarApp(ActionEvent actionEvent) {
        System.exit(0);
    }
}