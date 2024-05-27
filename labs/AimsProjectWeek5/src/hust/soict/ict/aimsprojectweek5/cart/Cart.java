package ict.aimsprojectweek5.cart;
import ict.aimsprojectweek5.media.Media;
import ict.aimsprojectweek5.media.DigitalVideoDisc;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.naming.LimitExceededException;

import java.util.Comparator;
import java.util.Collections.*;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    //    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
    public void addMedia(Media media) {
        try {
            if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
                for (Media media1 : itemsOrdered) {
                    if (media1.equals(media)) {
                        throw new Exception("ERROR: The disc is already in the cart!");
                    }
                }
                itemsOrdered.add(media);
            } else {
                throw new LimitExceededException("ERROR: The number of media has reached its limit!");
            }
        } catch (LimitExceededException e) {
            // Handle LimitExceededException
            System.err.println(e.getMessage());
            // You may choose to log the exception or perform other actions
        } catch (Exception e) {
            // Handle other exceptions
            System.err.println(e.getMessage());
            // You may choose to log the exception or perform other actions
        }
    }

    public void removeMedia(Media media) {
        try {
            if (itemsOrdered.isEmpty()) {
                throw new Exception("ERROR: The cart is empty!");
            }
            for (Media media1 : itemsOrdered) {
                if (media1.equals(media)) {
                    itemsOrdered.remove(media);
                    return;
                }
            }
            throw new Exception("ERROR: The disc is not in the cart!");
        } catch (Exception e) {
            // Handle other exceptions
            System.err.println(e.getMessage());
            // You may choose to log the exception or perform other actions
        }
    }

    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered items: ");
        for (Media media : itemsOrdered) {
            System.out.println(media.getId() + ". " + media.getTitle() + " - " + media.getCategory() + " - " + media.getCost());
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("***************************************************");
    }

    public ObservableList<Media> searchByID(Integer id) {
        ObservableList<Media> result = FXCollections.observableArrayList();
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
//                media.toString();
                result.add(media);
            }
        }
        return result;
    }

    public ObservableList<Media> searchByTitle(String title) {
        ObservableList<Media> result = FXCollections.observableArrayList();
        for (Media media : itemsOrdered) {
            if (media.getTitle().contains(title)) {
                result.add(media);
            }
        }
        return result;
    }


    public void sort(Comparator<Media> comparator) {
        itemsOrdered.sort(comparator);
    }

    public void clear() {
        itemsOrdered.clear();
    }

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }
}
