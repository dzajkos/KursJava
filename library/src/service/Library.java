package service;

import exception.ItemNotFoundException;
import model.Book;
import model.Item;
import model.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Library {

    private List<Item> items = new ArrayList<>();

    public void printAvailableItems() {
        List<String> descriptionsList = items.stream()
                .filter(item -> !item.isRented)
                .map(Item::getDescription)
                .toList();
        if(descriptionsList.isEmpty()) {
            System.out.println("Brak dostępnych tytułów");
        } else {
            descriptionsList.forEach(System.out::println);
        }
    }

    public void printRentedItems() {
        List<String> descriptionsList = items.stream()
                .filter(item -> item.isRented)
                .map(Item::getDescription)
                .toList();
        if(descriptionsList.isEmpty()) {
            System.out.println("Brak wypożyczonych tytułów");
        } else {
            descriptionsList.forEach(System.out::println);
        }
    }

    public void rentItem(String itemTitle) throws ItemNotFoundException {
        Item item = findByTitle(itemTitle)
                .orElseThrow(() -> new ItemNotFoundException("Nie ma takiego tytułu"));
        item.rent();
    }

    public void returnItem(String itemTitle) throws ItemNotFoundException {
        Item item = findByTitle(itemTitle)
                .orElseThrow(() -> new ItemNotFoundException("Nie ma takiego tytułu"));
        item.returnItem();
    }


    public void printAmounts() {
        if (Book.getCounter() == 0 && Movie.getCounter() == 0) {
            System.out.println("Biblioteka jest pusta :(");
        } else {
            System.out.printf("W bibliotece znajduje się %d książek i %d filmów%n", Book.getCounter(), Movie.getCounter());
        }
    }

    public Optional<Item> findByTitle(String itemTitle) {
        return items.stream()
                .filter(item -> item.getTitle().equals(itemTitle))
                .findFirst();
    }

}


