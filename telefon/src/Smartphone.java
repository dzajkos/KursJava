import java.awt.*;
import java.util.List;

public class Smartphone extends Mobile {

    protected List<Person> friends;

    public Smartphone(String comunicationInterface, Color color) {
        super(comunicationInterface, color);
    }

    @Override
    public void printCallHistory() {
        tenLastCalls.stream()
                .map(number -> formatNumber(number))
                .forEach(System.out::println);
    }

    public String formatNumber(String number) {
        return friends.stream()
                .filter(person -> person.number().equals(number))
                .findFirst()
                .map(Person::toString)
                .orElse(number);
    }
}


