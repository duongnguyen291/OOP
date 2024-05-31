package ict.aimsprojectweek5.media;
public class Disc extends Media{
    protected String director;
    protected int length;
    public Disc(int id, String title, String category,String director,int length, float cost) {
        super(id,title,category,cost);
        this.director = director;
        this.length = length;
    }
    public Disc(String title, String category,String director,int length, float cost) {
        super(title,category,cost);
        this.director = director;
        this.length = length;
    }
    public String getDirector() {
        return director;
    }
    public int getLength() {
        return length;
    }
    public boolean isMatchItem(Disc item) {
        return this.id == item.id &&
        this.title.equals(item.getTitle())&& 
        this.category.equals(item.getCategory()) &&
        this.cost == item.cost && 
        this.director.equals(item.getDirector()) && 
        this.length == item.length;
    }
}
