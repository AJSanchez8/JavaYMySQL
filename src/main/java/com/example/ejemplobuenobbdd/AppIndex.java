package com.example.ejemplobuenobbdd;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AppIndex extends Application {

    public static Connection conexion;
    @Override
    public void start(Stage stage) throws IOException {

        // Scene
        FXMLLoader fxmlLoader = new FXMLLoader(AppIndex.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        // Stage
        stage.setTitle("Aplicacion Bases de datos");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }

    public static void main(String[] args) {

        String url = """
                jdbc:mysql://localhost:3306/?allowPublicKeyRetrieval=true&useSSL=false
                """;
        conexion = null;

        try {
            conexion = DriverManager.getConnection(url,"root","root");
            System.out.println("Conectado a la base de datos :D");
        } catch (SQLException e){
            System.out.println("SQL Exception: "+e.getMessage());
            System.out.println("SQL Exception: "+e.getSQLState());
            System.out.println("SQL Exception: "+e.getErrorCode());
        }
        launch();
    }
}