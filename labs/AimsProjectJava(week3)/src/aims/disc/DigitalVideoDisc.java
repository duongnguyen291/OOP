package aims.disc;
public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private double cost;

    public DigitalVideoDisc(String title) {
        this.title = title;
    }

    public DigitalVideoDisc(String category, String title, double cost) {
        this.title = title;
        this.category = category;
        this.director = "NULL";
        this.length = 0;
        this.cost = cost;
    }

    public DigitalVideoDisc(String director, String category, String title, double cost) {
        this.director = director;
        this.category = category;
        this.title = title;
        this.cost = cost;
        this.length = 0;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, double cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }
    
    // Các phương thức getter không cần thay đổi

    public String getTitle() {
        return title;
    }
    public String getCategory() {
        return category;
    }
    public String getDirector() {
        return director;
    }
    public int getLength() {
        return length;
    }
    public double getCost() {
        return cost;
    }
    public void toString(int order){
        System.out.println(order + ".DVD - " +  this.getCategory()+ " - " + this.getDirector() + " - " + this.getLength()+ " - " + this.getCost() + " $");
    }
    public boolean isMatchTitle(String title){
        return this.getTitle() == title;
    }
    public boolean isMatchDVD(DigitalVideoDisc item){
        if(item == null) return false;
        return
            this.title == item.getTitle() && 
            this.category == item.getCategory() && 
            this.director == item.getDirector() && 
            this.length == item.getLength() &&
            this.cost == item.getCost();
    }

}
