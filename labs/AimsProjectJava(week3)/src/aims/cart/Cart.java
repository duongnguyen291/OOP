package aims.cart;
import aims.disc.*;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemOrder[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;
    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if(qtyOrdered == MAX_NUMBERS_ORDERED){
            System.out.println("The cart is full. Please remove some discs to continue.");
        }
        else{
            itemOrder[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added");
            if(qtyOrdered >= 18){
                System.out.println("The cart is almost full");
            }
        }

    }   
    public void removeDigitalVideoDisc (DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; ++i) {
            if(itemOrder[i] == disc) {
                System.out.println("The disc with title " + disc.getTitle() + " has been removed.");
                for (int j = i; j < qtyOrdered - 1; ++j)
                    itemOrder[j] = itemOrder[j + 1];
                itemOrder[qtyOrdered - 1] = null;
                qtyOrdered--;
                return;
            }
        }
        System.out.println("The disc with title " + disc.getTitle() + " is not found in cart.");
    }
    public float totalCost(){
        float res = 0;
        for(int i = 0; i < qtyOrdered; i++){
            res+=itemOrder[i].getCost();
        }
        return res;
    }
    public void orderedItem (){
        if(qtyOrdered <= 0){
            System.out.println("These is zeros disc in cart");
        }
        else{

            System.out.println("***********************CART***********************");
            System.out.println("Ordered Items");
            for(int i = 0; i < qtyOrdered; i++ ){
                itemOrder[i].toString(i+1);
            }
            System.out.println("**************************************************");
            System.out.println("Total Cost is: " + this.totalCost());
        }
    }
    public void searchByTitle(String title){
        if(qtyOrdered <= 0){
            System.out.println("These is zeros disc in cart");
        }
        else{
            int cnt = 1;
            int check = 0;
           for(int i = 0; i < qtyOrdered; i++){
                if(itemOrder[i].isMatchTitle(title)){
                    if(cnt == 1){
                        System.out.println("These are list of DVD with tile: " + title);
                    }
                    itemOrder[i].toString(cnt);
                    cnt++;
                    check = 1;
                }
            } 
            if(check == 0){
                System.out.println("These is zeros disc has name " + title + "in cart");
            }

        }
    }
}
