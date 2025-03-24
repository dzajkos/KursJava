package service;

import exception.ItemNotFoundException;
import model.Book;
import model.Item;
import model.Movie;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Item> items = new ArrayList<>();

    public void printAvailableItems() {
        boolean flag = false;
        for (Item item : items) {
            if (!item.isRented) {
                flag = true;
                System.out.println(item.getDescription());
            }
        }
        if (flag) {
            System.out.println("Brak dostępnych tytułów");
        }

    }

    public void printRentedItems() {
        boolean flag = false;
        for (Item item : items) {
            if (item.isRented) {
                flag = true;
                System.out.println(item.getDescription());
            }
        }
        if (flag) {
            System.out.println("Brak wypożyczonych tytułow");
        }
    }

    public void rentItem(String itemTitle) throws ItemNotFoundException {
        Item item = findByTitle(itemTitle);
        if (item == null) {
            throw new ItemNotFoundException("Nie ma takiego tyutłu");
        }
        item.rent();
    }

    public void returnItem(String itemTitle) throws ItemNotFoundException {
        Item item = findByTitle(itemTitle);
        if (item == null) {
            throw new ItemNotFoundException("Nie ma takiego tyutłu");
        }
        item.returnItem();
    }


    public void printAmounts() {
        if (Book.getCounter() == 0 && Movie.getCounter() == 0) {
            System.out.println("Biblioteka jest pusta :(");
        } else {
            System.out.printf("W bibliotece znajduje się %d książek i %d filmów%n", Book.getCounter(), Movie.getCounter());
        }
    }

    public Item findByTitle(String itemTitle) {
        for (Item item : items) {
            if (item.getTitle().equals(itemTitle)) {
                return item;
            }
        }
        return null;
    }

}


