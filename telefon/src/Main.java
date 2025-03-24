import java.awt.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Phone phone1 = new Phone("???", Color.YELLOW);
        Mobile mobile = new Mobile("??????", Color.GRAY);
        Smartphone smartphone = new Smartphone("?? ? ?", Color.BLACK);

        smartphone.friends = List.of( new Person("Jan", "Kowalski", "123-456-789"),
                new Person("Anna", "Nowak", "987-654-321"),
                new Person("Piotr", "Wiśniewski", "555-666-777"));

        List<Phone> listOfPhones = List.of(phone1, mobile, smartphone);
        List<String> numbers = List.of( "123-456-789", "111-222-333", "987-654-321", "444-555-666", "555-666-777",
                "777-888-999", "123-456-789", "222-333-444", "987-654-321", "666-777-888");

        listOfPhones.forEach(phone -> numbers
                .forEach(phone::call));

        listOfPhones.forEach(Phone::printCallHistory);



    }
}
