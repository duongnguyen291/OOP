package aims;
import aims.cart.*;
import aims.media.*;
public class Aims {
    
    public static void main(String[] args) {
        Cart anOrder = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 100);
        anOrder.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 100);
        anOrder.addMedia(dvd2);

        Book book1 = new Book("Java for Beginners", "Education", 100, 1244);
        anOrder.addMedia(book1);

        CompactDisc cd1 = new CompactDisc("Best of 80s", "Music", "Various Artists","Duong", 1223, 100);
        anOrder.addMedia(cd1);

        anOrder.orderedItems();
        anOrder.searchByTitle("The Lion King");

    }
}