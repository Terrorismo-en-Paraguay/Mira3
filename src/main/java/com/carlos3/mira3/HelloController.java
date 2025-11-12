package com.carlos3.mira3;

import com.carlos3.mira3.modelo.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.awt.*;

public class HelloController {

    @FXML
    private TextField usuario;

    @FXML
    private TextField contrasenia;

    private Usuario usuarioObj;

    @FXML
    protected void onLogin() {
        usuarioObj = new Usuario();
        usuarioObj.setNombre(usuario.getText());
        contrasenia.setText(contrasenia.getText());
    }
}