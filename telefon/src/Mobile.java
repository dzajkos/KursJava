import java.awt.*;
import java.util.List;

public class Mobile extends Phone {

    protected List<String> tenLastCalls;

    public Mobile(String comunicationInterface, Color color) {
        super(comunicationInterface, color);
    }

    @Override
    public void call(String number) {
        super.call(number);
        tenLastCalls.add(number);

    }

    @Override
    public void printCallHistory() {
        tenLastCalls.forEach(System.out::println);
    }
}
