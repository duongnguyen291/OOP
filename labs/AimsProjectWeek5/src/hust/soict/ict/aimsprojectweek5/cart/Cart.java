package ict.aimsprojectweek5.cart;
import ict.aimsprojectweek5.media.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.naming.LimitExceededException;

import java.util.Comparator;
import java.util.Collections.*;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    //    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
    public void initData() {
        // Thêm một số sách vào giỏ hàng
        addMedia(new Book(1, "Java Programming", "Education", "John Smith", 25.0f, 123));
        addMedia(new Book(2, "Python Basics", "Education", "Alice Johnson", 20.0f, 124));
        addMedia(new Book(3, "Data Structures", "Education", "David Lee", 30.0f, 125));
        addMedia(new Book(4, "Algorithms", "Education", "Emily Wang", 28.0f, 126));
        addMedia(new Book(5, "Machine Learning", "Education", "Michael Brown", 35.0f, 127));

        // Thêm một số đĩa DVD vào giỏ hàng
        addMedia(new DigitalVideoDisc("The Matrix", "Action", "Wachowski Brothers", 120, 15.0f));
        addMedia(new DigitalVideoDisc("Inception", "Science Fiction", "Christopher Nolan", 150, 18.0f));
        addMedia(new DigitalVideoDisc("The Godfather", "Crime", "Francis Ford Coppola", 180, 20.0f));
        addMedia(new DigitalVideoDisc("The Shawshank Redemption", "Drama", "Frank Darabont", 140, 16.0f));
        addMedia(new DigitalVideoDisc("Pulp Fiction", "Crime", "Quentin Tarantino", 160, 17));

        // Thêm một số đĩa CD vào giỏ hàng
        CompactDisc cd1 = new CompactDisc("Album A", "Pop", "Singer A", "Band A", 60, 12.0f);
        cd1.addTrack(new Track("Song 1", 4));
        cd1.addTrack(new Track("Song 2", 5));
        cd1.addTrack(new Track("Song 3", 3));
        addMedia(cd1);

        CompactDisc cd2 = new CompactDisc("Album B", "Rock", "Singer B", "Band B", 65, 14.0f);
        cd2.addTrack(new Track("Track 1", 4));
        cd2.addTrack(new Track("Track 2", 5));
        cd2.addTrack(new Track("Track 3", 3));
        addMedia(cd2);

        CompactDisc cd3 = new CompactDisc("Album C", "Jazz", "Singer C", "Band C", 70, 16.0f);
        cd3.addTrack(new Track("Jazz 1", 4));
        cd3.addTrack(new Track("Jazz 2", 5));
        cd3.addTrack(new Track("Jazz 3", 3));
        addMedia(cd3);

        CompactDisc cd4 = new CompactDisc("Album D", "Hip-hop", "Singer D", "Band D", 55, 13.0f);
        cd4.addTrack(new Track("Hip-hop 1", 4));
        cd4.addTrack(new Track("Hip-hop 2", 5));
        cd4.addTrack(new Track("Hip-hop 3", 3));
        addMedia(cd4);

        CompactDisc cd5 = new CompactDisc("Album E", "Classical", "Singer E", "Band E", 75, 18.0f);
        cd5.addTrack(new Track("Classical 1", 4));
        cd5.addTrack(new Track("Classical 2", 5));
        cd5.addTrack(new Track("Classical 3", 3));
        addMedia(cd5);
    }

    public void addMedia(Media media)  {
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
