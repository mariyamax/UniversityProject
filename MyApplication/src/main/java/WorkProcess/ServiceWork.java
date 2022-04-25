package WorkProcess;

import Data.myData;
import com.example.myapplication.HelloController;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceWork {
    public static myData savedGame;
    public static boolean again=true;
    public static void processReader(int count, int value) throws IOException, ClassNotFoundException {
        if(count==0){
            count++;
            FileInputStream fileInputStream = new FileInputStream("C:\\Program Files\\MyApplication\\src\\main\\java\\Data\\myBD.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            savedGame = (myData) objectInputStream.readObject();
            System.out.println(savedGame);
        }

        System.out.println("I still work");
        int CurrentValue = value;
        Runtime runtime = Runtime.getRuntime();
        List tasklist = new ArrayList();

        Process process = runtime.exec("tasklist");
        BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String s = "";

        while((s = br.readLine()) != null) {
            if ("".equals(s)) {
                continue;
            }
            if ((s.contains("notepad.exe"))) {
                tasklist.add(s);
                value = tasklist.size();
            }
        }
        if (value==1){
           savedGame.decrementTime();
           System.out.println(savedGame.getTime());
            FileOutputStream outputStream = null;
            try {
                outputStream = new FileOutputStream("C:\\Program Files\\MyApplication\\src\\main\\java\\Data\\myBD.txt");
                ObjectOutputStream objectOutputStream = null;
                objectOutputStream = new ObjectOutputStream(outputStream);
                objectOutputStream.writeObject(savedGame);
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(Double.parseDouble(savedGame.getTime())<0.001){
            //TODO write work with contract
            System.out.println("I'm reade to send contract");
        }
        if(again){
            try {
                Thread.sleep(36000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            processReader(count, value);}


    }
    public static void stopProcess(){
        again=false;
    }
}
