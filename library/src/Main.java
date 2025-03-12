public class Main {

    public static void main(String[] args) {

        Library library = new Library();
        library.items.add(new Book("Siema", "Maciek", 300));
        library.items.add(new Movie("DUpa", 120, "Rafał"));

        library.printAvailableItems();
    }

}
