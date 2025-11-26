package com.carlos3.mira3;

import com.carlos3.mira3.modelo.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.*;
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
    }

    @FXML
    public void handlerIniciarSesion(ActionEvent actionEvent) {
        String login = inputLogin.getText();
        String password = inputPassword.getText();

        MainApp.usuario_actual = null;

        for (Usuario a : MainApp.listaUsuarios) {
            if (a.getNombre().equalsIgnoreCase(login)
                    && a.getPassword().equalsIgnoreCase(password)) {
                MainApp.usuario_actual = a;
            }
        }
        if (MainApp.usuario_actual == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR,"El nombre del usuario o contraseña no son correctos", ButtonType.OK);
            alert.showAndWait();
            inputLogin.setText("");
            inputPassword.setText("");
        } else {
            Stage ventana = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            cambiarEscena(ventana);
        }
    }

    private void cambiarEscena(Stage ventana) {
        Scene escena;
        InfoUserController controlador;
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("InfoAlbum-view.fxml"));

        try {
            escena = new Scene(fxmlLoader.load());
            controlador = fxmlLoader.getController();
            controlador.EnviarAlbum(MainApp.usuario_actual);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ventana.hide();
        ventana.setScene(escena);
        ventana.show();
    }
    public void handlerCerrarApp(ActionEvent actionEvent) {
        System.exit(0);
    }
}