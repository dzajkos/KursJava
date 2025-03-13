import service.Library;

public class Main {

    public static void main(String[] args) {

        Library library = new Library();
        library.items.add(new model.Book("Siema", "Maciek", 300));
        library.items.add(new model.Movie("DUpa", 120, "Rafał"));

        UserInterface userInterface = new UserInterface();

        userInterface.startInterface();


    }

}
