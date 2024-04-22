package aims.store;
import aims.disc.*;
// import aims.cart.*;

public class Store {
    public static final int MAX_NUMBERS_ORDERED = 1000;
    DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyItem = 0;
    public void addDVD(DigitalVideoDisc item){
        int flag = -1;
        for(int i = 0; i < MAX_NUMBERS_ORDERED ;i++){
            if(itemsInStore[i].isMatchDVD(item)){
                System.out.println("These is already have this item in Store");
                return;
            }   
            if(itemsInStore[i] == null){
                //Flag if this location dont have any items
                flag = i;
            }   
        }
        if(flag != -1){
            //Add new items
            itemsInStore[flag] = item;
            qtyItem++;
        } 
    }
    public void removeDVD(DigitalVideoDisc item){
        int check = 0;
        for(int i = 0;i < MAX_NUMBERS_ORDERED;i++){
            if(itemsInStore[i].isMatchDVD(item)){
                check = 1;
                itemsInStore[i] = null;
                qtyItem--;
            }
        }
        if(check == 0){
            System.out.println("These is no item in Store");
        }
    }
    public void listItem (){
        if(qtyItem <= 0){
            System.out.println("These is zeros items in store");
        }
        else{

            System.out.println("***********************STORE***********************");
            System.out.println("Store");
            int cnt = 1;
            for(int i = 0; i < MAX_NUMBERS_ORDERED; i++ ){
            if(itemsInStore[i] != null){
                itemsInStore[i].toString(cnt);
                cnt++;
                } 
            }
        }
    }
}   
