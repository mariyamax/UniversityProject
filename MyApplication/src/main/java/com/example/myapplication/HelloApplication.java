package com.example.myapplication;

import WorkProcess.ServiceWork;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;



public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage.setTitle("StopGame");
        stage.setScene(new Scene(root,760,475));
        stage.setResizable(false);
        stage.show();
    }
    @Override
    public void stop(){
        ServiceWork.stopProcess();
    }

    public static void main(String[] args) {
        launch();
    }
}