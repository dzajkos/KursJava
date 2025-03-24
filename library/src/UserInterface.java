import exception.ItemAlreadyInThisState;
import exception.ItemNotFoundException;
import service.Library;

import java.util.Scanner;

public class UserInterface {

    private int option = 9;
    Scanner scanner = new Scanner(System.in);
    Library library = new Library();

    public void startInterface () {

        while (option != 0) {
            System.out.printf("%nDostępne opcje:%n" +
                    "1. Wyświetl listę dostępnych tytułów %n" +
                    "2. Wyświetl listę wypożyczonych tytułów %n" +
                    "3. Wypożycz tytuł %n" +
                    "4. Zwróc tytuł %n" +
                    "5. Wyświetl liczbę książek i filmów w bibliotece %n%n" +
                    "0. Wyjście z programu%n");

            option = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (option) {
                    case 1 -> library.printAvailableItems();
                    case 2 -> library.printRentedItems();
                    case 3 -> rentItem();
                    case 4 -> returnItem();
                    case 5 -> library.printAmounts();
                }
            } catch (ItemNotFoundException | ItemAlreadyInThisState e) {
                System.err.println(e.getMessage());
            }
        }

    }

    private void rentItem () throws ItemNotFoundException {
        System.out.println("Podaj tytuł pozycji którą chcesz wypożyczyć:");
        library.rentItem(scanner.nextLine());
    }

    private void returnItem () throws ItemNotFoundException {
        System.out.println("Podaj tytuł pozycji którą chcesz zwrócić:");
        library.returnItem(scanner.nextLine());
    }

}
