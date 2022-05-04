package com.example.myapplication;

import Data.myData;
import WorkProcess.ServiceWork;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.*;
import java.time.LocalDate;

import static WorkProcess.ServiceWork.processReader;

public class HelloController {
    private myData Data;
    @FXML
    private TextField Wallet;
    @FXML
    private TextField Temps;
    @FXML
    private TextField Month;
    @FXML
    private TextField Days;
    @FXML
    private Label Alarm;
    @FXML
    private Label Transaction;

    private static ServiceWork myWork;
    @FXML
    protected void Continue()  {
        boolean test = true;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("C:\\myApplication\\src\\main\\java\\Data\\myBD.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Data = (myData) objectInputStream.readObject();
            System.out.println(Data.getDeadLine());
            if (Data.getDeadLine().isBefore(LocalDate.now())){
                test = false;
            }}
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        if(test){
            myWork = new ServiceWork();
            myWork.start();
            if(Double.parseDouble(Data.getTemps())<0.001){

            }
        }
    }

    @FXML
    protected void Start() {
        try{
            String walletText = Wallet.getText();
            String tempsText = Temps.getText();
            String monthText =Month.getText();
            String daysText= Days.getText();
            Data = new myData(walletText,tempsText,monthText,daysText);
            FileOutputStream outputStream = null;
            try {
                outputStream = new FileOutputStream("C:\\myApplication\\src\\main\\java\\Data\\myBD.txt");
                ObjectOutputStream objectOutputStream = null;
                objectOutputStream = new ObjectOutputStream(outputStream);
                objectOutputStream.writeObject(Data);
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            myWork = new ServiceWork();
            myWork.start();
            Transaction();
        }
    catch (RuntimeException e){
            Alarm.setText("your wrong input will break my program");
        }

    }
    @FXML
    protected void ConsoleTest() throws FileNotFoundException {
       FileInputStream fileInputStream = new FileInputStream("C:\\myApplication\\src\\main\\java\\Data\\myBD.txt");
       System.out.println(fileInputStream.toString());
    }
    @FXML
    protected void Transaction(){
        try {
            FileInputStream fileInputStream = new FileInputStream("C:\\myApplication\\src\\main\\java\\Data\\myBD.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Data = (myData) objectInputStream.readObject();}
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("It's ok, I'm work: "+Data.getTemps());
        if (Double.parseDouble(Data.getTemps())<=0.01){
            System.out.println("Even here I'm work");
            Transaction.setText("I will send the transaction soon and close your application");
        }
        else  {
            try {
                Thread.sleep(20000);
                Transaction();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}