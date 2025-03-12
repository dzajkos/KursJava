import java.util.ArrayList;
import java.util.List;

public class Library {

    List<Item> items = new ArrayList<>();

    public void printAvailableItems () {
        for (Item item : items) {
            if (!item.isRented) {
                System.out.println(item.getDescription());
            }
        }
    }
    public void printRentedItems () {
        for (Item item : items) {
            if (item.isRented) {
                System.out.println(item.getDescription());
            }
        }
    }



}
