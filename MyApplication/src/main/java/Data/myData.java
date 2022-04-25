package Data;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.time.LocalDate;

public class myData implements Serializable {
    private static final long serialVersionUID = 1L;

    private String purse;
    private String time;
    private LocalDate deadLine;

    public myData(String purse,String time, String month, String days){
        this.purse = purse;
        this.time = time;
        System.out.println(month);
        System.out.println(days);
        deadLine= LocalDate.now().plusMonths(Integer.parseInt(month)).plusDays(Integer.parseInt(days));
    }
    public LocalDate getDeadLine(){
        return deadLine;
    }
    public String getPurse() {
        return purse;
    }

    public void setPurse(String purse) {
        this.purse = purse;
    }

    public String getTime() {
        return time;
    }

    public void decrementTime() {
        double time = Double.parseDouble(this.time);
        time = time-0.01;
        this.time= String.valueOf(time);
    }
    @Override
    public String toString() {
        return "purse=" + String.valueOf(purse) + "timeLimit=" + String.valueOf(time)
                 + "deadLine=" + String.valueOf(deadLine);
    }


}

