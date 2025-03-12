public class Movie extends Item {

    private static int counter = 0;
    private String director;
    private int duration;

    public Movie(String title, int duration, String director) {
        super(title);
        this.duration = duration;
        this.director = director;
    }

    @Override
    public String getDescription() {
        return String.format("Reżyser: %s, Tytuł: %s, Długość filmu: %d minut", director, title, duration);
    }
}
