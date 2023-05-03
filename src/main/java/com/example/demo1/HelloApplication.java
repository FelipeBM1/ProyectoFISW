package com.example.demo1;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("sample.fxml"));
        AnchorPane root = fxmlLoader.load();

        // Obtener las referencias a los elementos del FXML
        @FXML AnchorPane Usuarioflecha;
        @FXML AnchorPane Registroflecha;
        @FXML AnchorPane Objetivoflecha;
        @FXML AnchorPane Montoflecha;

        @FXML AnchorPane Usuario;
        @FXML AnchorPane Registro;
        @FXML AnchorPane Objetivo;
        @FXML AnchorPane Monto;

        // Establecer los eventos de arrastrar y soltar para la ventana
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xoffset = event.getScreenX();
                yoffset = event.getScreenY();
            }
        });

        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setX(event.getScreenX() - xoffset);
                primaryStage.setY(event.getScreenY() - yoffset);
            }
        });

        Scene scene = new Scene(root);
        primaryStage.setTitle("Hello!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
