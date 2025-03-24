import java.awt.*;

public class Phone {

    protected String comunicationInterface;
    protected Color color;

    public Phone(String comunicationInterface, Color color) {
        this.comunicationInterface = comunicationInterface;
        this.color = color;
    }

    public void call(String number) {
        System.out.println(number);
    }

    public void printCallHistory() {
        System.out.println("No history");
    }

}
