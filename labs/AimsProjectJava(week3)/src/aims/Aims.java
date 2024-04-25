package aims;

import aims.cart.*;
import aims.store.*;
import aims.media.*;

import java.util.Scanner;

public class Aims {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Store store = new Store();
    private static final Cart cart = new Cart();

    public static void showMenu() {
        System.out.println("AIMS:");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu() {
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }
    public static void updateStore(){
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Add media from store");
        System.out.println("2. Remove media from store");
        System.out.println("3. Back");

        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }
    public static void main(String[] args) {
        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStoreLogic();
                    break;
                case 3:
                    seeCurrentCart();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
        scanner.close();
    }

    private static void viewStore() {
        int choice;
        do {
            storeMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    seeMediaDetails();
                    break;
                case 2:
                    addToCart();
                    break;
                case 3:
                    playMedia();
                    break;
                case 4:
                    System.out.println("Current Cart:");
                    cart.orderedItems();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    private static void seeMediaDetails() {
        System.out.println("Enter title of the media:");
        scanner.nextLine(); // Consume newline character
        String title = scanner.nextLine();
        Media media = store.searchMedia(title);
        if (media != null) {
            System.out.println(media);
            int choice;
            do {
                mediaDetailsMenu();
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        cart.addMedia(media);
                        break;
                    case 2:
                        if (media instanceof Playable) {
                            ((Playable) media).play();
                        } else {
                            System.out.println("Media is not playable.");
                        }
                        break;
                    case 0:
                        System.out.println("Back to the previous menu.");

                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 0);
        } else {
            System.out.println("Media not found.");
        }
    }

    private static void addToCart() {
        System.out.println("Enter title of the media:");
        scanner.nextLine(); // Consume newline character
        String title = scanner.nextLine();
        Media media = store.searchMedia(title);
        if (media == null) {
            cart.addMedia(media);
            System.out.println("Media added to cart.");
            System.out.println("Number DVD in the cart is: " + cart.numberDVD());
            
        } else {
            System.out.println("This item is already in the cart.");
        }
    }

    private static void playMedia() {
        System.out.println("Enter title of the media:");
        scanner.nextLine(); // Consume newline character
        String title = scanner.nextLine();
        Media media = store.searchMedia(title);
        if (media != null && media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("Playable media not found.");
        }
    }
    private static void addToStore() {
        System.out.println("Enter title of the media:");
        scanner.nextLine(); // Consume newline character
        String title = scanner.nextLine();
        Media media = store.searchMedia(title);
        if (media == null) {
            store.addMedia(media);
            System.out.println(" Media added to store.");
 
        } else {
            System.out.println("This item is already in the store.");
        }
    }
    private static void removeToStore() {
        System.out.println("Enter title of the media:");
        scanner.nextLine(); // Consume newline character
        String title = scanner.nextLine();
        Media media = store.searchMedia(title);
        if (media != null) {
            store.removeMedia(media);
            System.out.println(" Media removed to store.");
 
        } else {
            System.out.println("This item is not in the store.");
        }
    }
    private static void updateStoreLogic() {
        // Implement logic to add/remove media from store
        int choice = -1;
        do {
            updateStore();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addToStore();
                    break;
                case 2:
                    removeToStore();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

    }
    private static void seeCurrentCart() {
        System.out.println("Current Cart:");
    
        cart.orderedItems();
        int choice = -1;
        do {
            cartMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the title to filter by:");
                    scanner.nextLine(); // consume newline character
                    String titleToFilter = scanner.nextLine();
                    cart.filterByTitle(titleToFilter);
                    break;
                case 2:
                    System.out.println("Sort by:\n1. Title\n2. Cost");
                    int sortChoice = scanner.nextInt();
                    switch (sortChoice) {
                        case 1:
                            cart.sortByTitle();
                            break;
                        case 2:
                            cart.sortByCost();
                            break;
                        default:
                            System.out.println("Invalid choice. Sorting by title by default.");
                            cart.sortByTitle();
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Enter the title to remove from cart:");
                    scanner.nextLine(); // consume newline character
                    String titleToRemove = scanner.nextLine();
                    Media mediaToRemove = cart.searchMedia(titleToRemove);
                    if (mediaToRemove != null) {
                        cart.removeMedia(mediaToRemove);
                    } else {
                        System.out.println("Item not found in cart.");
                    }
                    break;   
                case 4:
                    System.out.println("Enter the title to play:");
                    scanner.nextLine(); // consume newline character
                    String titleToPlay = scanner.nextLine();
                    Media mediaToPlay = cart.searchMedia(titleToPlay);
                    if (mediaToPlay != null) {
                        cart.playMedia(mediaToPlay);
                    } else {
                        System.out.println("Item not found in cart.");
                    }
                    break;                     
                case 5:
                    cart.placeOrder();
                    System.out.println("Thank you for your order.");
                    break;                     
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }
    

}
