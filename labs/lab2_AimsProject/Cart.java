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
}
