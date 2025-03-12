public abstract class Item {
    protected final String title;
    protected boolean isRented = false;

    public Item(String title) {
        this.title = title;
    }

    public abstract String getDescription();

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public String getTitle() {
        return title;
    }

}
