package ict.aimsprojectweek5.store;

import ict.aimsprojectweek5.media.*;
import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<>();
    private int qtyItem = 0;
    public void initData() {
        // Khởi tạo 10 sách
        addMedia(new Book(1, "Java Programming", "Education", "John Smith", 25.0f, 123));
        addMedia(new Book(2, "Python Basics", "Education", "Alice Johnson", 20.0f, 124));
        addMedia(new Book(3, "Data Structures", "Education", "David Lee", 30.0f, 125));
        addMedia(new Book(4, "Algorithms", "Education", "Emily Wang", 28.0f, 126));
        addMedia(new Book(5, "Machine Learning", "Education", "Michael Brown", 35.0f, 127));
        addMedia(new Book(6, "History of Art", "History", "Sophia Davis", 18.0f, 128));
        addMedia(new Book(7, "World War II", "History", "William Wilson", 22.0f, 129));
        addMedia(new Book(8, "Ancient Civilizations", "History", "Olivia Martinez", 26.0f, 130));
        addMedia(new Book(9, "Literature Classics", "Literature", "Ethan Taylor", 32.0f, 131));
        addMedia(new Book(10, "Modern Poetry", "Literature", "Ava Anderson", 15.0f, 132));
    
        // Khởi tạo 5 DigitalVideoDisc
        addMedia(new DigitalVideoDisc("The Matrix", "Action", "Wachowski Brothers", 120, 15.0f));
        addMedia(new DigitalVideoDisc("Inception", "Science Fiction", "Christopher Nolan", 150, 18.0f));
        addMedia(new DigitalVideoDisc("The Godfather", "Crime", "Francis Ford Coppola", 180, 20.0f));
        addMedia(new DigitalVideoDisc("The Shawshank Redemption", "Drama", "Frank Darabont", 140, 16.0f));
        addMedia(new DigitalVideoDisc("Pulp Fiction", "Crime", "Quentin Tarantino", 160, 17));
    
        // Khởi tạo 5 CompactDisc
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
    public int getQuantity(){
        return this.qtyItem;
    }
    public void addMedia(Media media) {
        for (Media item : itemsInStore) {
            if (item.isMatchItem(media)) {
                System.out.println("This item is already in the store");
                return;
            }
        }
        itemsInStore.add(media);
        qtyItem++;
    }

    public void removeMedia(Media media) {
        boolean found = false;
        for (int i = 0; i < itemsInStore.size(); i++) {
            if (itemsInStore.get(i).isMatchItem(media)) {
                itemsInStore.remove(i);
                qtyItem--;
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Item not found in store");
        }
    }

    public void listItem() {
        if (qtyItem <= 0) {
            System.out.println("There are no items in the store.");
        } else {
            System.out.println("*********************** STORE ***********************");
            System.out.println("Store");
            int cnt = 1;
            for (Media media : itemsInStore) {
                media.toStringItem(cnt);
                cnt++;
            }
        }
    }
    public Media searchMedia(Media item) {
        for (Media media : itemsInStore) {
            if (media.isMatchItem(item)) {
                return media;
            }
        }
        return null; 
    }
    public Media searchByTitle(String title){
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }
    public ArrayList<Media> getItemsInStore(){
        return this.itemsInStore;
    }   
}
