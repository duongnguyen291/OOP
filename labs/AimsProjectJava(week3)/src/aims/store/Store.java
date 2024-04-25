package aims.store;

import aims.media.*;
import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<>();
    private int qtyItem = 0;

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
    public Media searchMedia(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null; 
    }
}
