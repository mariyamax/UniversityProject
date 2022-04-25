package com.example.myapplication;

import Data.myData;
import WorkProcess.ServiceWork;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.*;
import java.time.LocalDate;

public class HelloController {

    @FXML
    private TextField PurseField;

    @FXML
    private TextField days;

    @FXML
    private TextField month;

    @FXML
    private TextField TimeLimit;

    @FXML
    private Pane mainPane;

    @FXML
    private Button refreshButton;

    @FXML
    private Button submitButton;

//TODO WorkProcessReader in time
    @FXML
    public void initialize() {
       submitButton.setOnAction(event -> {
           if (PurseField.getCharacters()!=null){
              // System.out.println(TimeLimit.getText()+month.getText()+days.getText()+PurseField.getText());
               String timeLimit = String.valueOf(TimeLimit.getText());
               String Month = month.getText();
               String Days = String.valueOf(days.getText());
               String purse = PurseField.getText();
               myData data = new myData(purse,timeLimit,Month,Days);
               FileOutputStream outputStream = null;
               try {
                   outputStream = new FileOutputStream("C:\\Program Files\\MyApplication\\src\\main\\java\\Data\\myBD.txt");
               ObjectOutputStream objectOutputStream = null;
                   objectOutputStream = new ObjectOutputStream(outputStream);
                   objectOutputStream.writeObject(data);
                   objectOutputStream.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
           try {
               ServiceWork.processReader(0,0);
           } catch (IOException | ClassNotFoundException e) {
               e.printStackTrace();
           }
       });
        refreshButton.setOnAction(event -> {
            boolean test = true;
            FileInputStream fileInputStream = null;
            try {
                fileInputStream = new FileInputStream("C:\\Program Files\\MyApplication\\src\\main\\java\\Data\\myBD.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            myData savedData = (myData) objectInputStream.readObject();
                System.out.println(savedData.getDeadLine());
            if (savedData.getDeadLine().isBefore(LocalDate.now())){
                test = false;
            }}
            catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            if(test){
            try {
                ServiceWork.processReader(0,0);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }});
    }

}