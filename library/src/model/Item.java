package model;

import exception.ItemAlreadyInThisState;

public abstract class Item {
    protected final String title;
    public boolean isRented = false;

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

    public void rent() {
        if (isRented()) {
            throw new ItemAlreadyInThisState("Tytuł jest już wypożyczony");
        } else {
            setRented(true);
        }
    }

    public void returnItem () {
        if (!isRented()) {
            throw new ItemAlreadyInThisState("Tytuł jest już zwrócony");
        } else {
            setRented(false);
        }
    }

}
