package Data;

import java.io.Serializable;
import java.time.LocalDate;

public class myData implements Serializable {
    private static final long serialVersionUID = 1L;

    private String Wallet;
    private String Temps;
    private LocalDate DeadLine;

    public myData(String Wallet, String Temps, String Month, String Days) {
        this.Wallet = Wallet;
        this.Temps = Temps;
        DeadLine = LocalDate.now().plusMonths(Integer.parseInt(Month)).plusDays(Integer.parseInt(Days));
    }

    public LocalDate getDeadLine() {
        return DeadLine;
    }

    public String getWallet() {
        return Wallet;
    }

    public void setWallet(String Wallet) {
        this.Wallet = Wallet;
    }

    public String getTemps() {
        return Temps;
    }

    public void decrementTime() {
        double Temps = Double.parseDouble(this.Temps);
        Temps = Temps - 0.01;
        this.Temps = String.valueOf(Temps);
    }

    @Override
    public String toString() {
        return "Wallet" + String.valueOf(Wallet) + "YourTime" + String.valueOf(Temps)
                + "DeadLine" + String.valueOf(DeadLine);
    }
}
