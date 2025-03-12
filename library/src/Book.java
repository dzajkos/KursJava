public class Book extends Item {

    private static int counter = 0;
    private final String author;
    private final int pagesCunt;

    public Book(String title, String author, int pagesCunt) {
        super(title);
        this.author = author;
        this.pagesCunt = pagesCunt;
    }

    @Override
    public String getDescription() {
         return String.format("Autor: %s, Tytuł: %s, Liczba stron: %d", author, title, pagesCunt);
    }
}
