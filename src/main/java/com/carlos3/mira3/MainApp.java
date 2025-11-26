package com.carlos3.mira3;

import com.carlos3.mira3.modelo.Modulo;
import com.carlos3.mira3.modelo.Usuario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MainApp extends Application {
    public static ArrayList<Usuario> listaUsuarios  = new ArrayList<>();

    public static Usuario usuario_actual;
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Loggin");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void init() {
        Gson gson = new Gson();

        try (FileReader fichero  = new FileReader("datos/listaUsuarios.json")) {
            listaUsuarios = gson.fromJson(fichero,new TypeToken<ArrayList<Usuario>>(){}.getType());
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: El fichero datos/listaUsuarios.json NO EXISTE");
        } catch (IOException e) {
            System.out.println("Se ha producido un ERROR al leer el fichero datos/listaUsuarios.json");
        }

    }

    @Override
    public void stop() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter fichero = new FileWriter("datos/listaUsuarios.json")) {
            gson.toJson(listaUsuarios,fichero);
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: El fichero datos/listaUsuarios.json NO EXISTE");
        } catch (IOException e) {
            System.out.println("Se ha producido un ERROR al leer el fichero datos/listaUsuarios.json");
        }
        System.out.println("Se han guardado " + listaUsuarios.size()+ " usuarios con sus respectivas notas");
    }

    public static void main(String[] args) {
        launch();
    }
}