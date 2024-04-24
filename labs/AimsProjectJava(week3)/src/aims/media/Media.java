package aims.media;

public class Media {
    protected int id;
    protected String title;
    protected String category;
    protected double cost;

    public Media(int id, String title, String category, double cost){
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost; 
    }
    public Media(String title, String category, double cost){
        this.title = title;
        this.category = category;
        this.cost = cost; 
    }


    public int getId(){
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getCategory() {
        return category;
    }
    public double getCost() {
        return cost;
    }
    public void toStringItem(int order) {
        System.out.println(order + ".Media - " + title + " - " + category + " - " + cost + " $");
    }
    public boolean isMatchItem(Media item){
        return this.id == item.id &&
            this.title == item.title && 
            this.category == item.category &&
            this.cost == item.cost; 
    }
}
