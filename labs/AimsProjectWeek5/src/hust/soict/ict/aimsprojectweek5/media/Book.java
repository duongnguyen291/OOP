package ict.aimsprojectweek5.media;
import java.util.ArrayList;

public class Book extends Media{

    private int token;
    private ArrayList<String>  listOfAuthors  = new ArrayList<>();


    public Book(int id, String title, String category, String author, float cost, int token){
        super(id, title,category, cost);
        this.token = token;
        this.listOfAuthors.add(author);
    }
    public Book(int id, String title, String category, float cost, int token){
        super(id, title,category, cost);
        this.token = token;
    }
    public Book(String title, String category, float cost, int token){
        super(title,category, cost);
        this.token = token;

    }
    public Book(String title, String category,String author, float cost, int token){
        super(title,category, cost);
        this.token = token;
        this.listOfAuthors.add(author);
    }
    public int getToken(){
        return token;
    }
    @Override
    // String title, String category, float cost, int token
    public void toStringItem(int order){
        System.out.println(order + ".Book - " +  this.getTitle()+ " - " + this.getCategory()  + " - " + this.getToken() + " - " + this.getCost() + " $");
    }
    public void addAuthor(String authorInput){
        try {
            if(listOfAuthors.size() < 5) {
                for (String author : listOfAuthors) {
                    if (author.equals(authorInput)) {
                        System.out.println("This author is already in the list");
                        return;
                    }
                }
                listOfAuthors.add(authorInput);
            }
            else{
                throw new Exception("Authors has reach its limit");
            }
        }catch (Exception e){
            System.err.println(e.getMessage());
        }

    }
    public void removeAuthor(String authorInput){

        System.out.println("Song not found in TrackList");
        try {
            if (listOfAuthors.isEmpty()) {
                throw new Exception("Authors list is empty");
            }
            else if (listOfAuthors.contains(authorInput)) {
                listOfAuthors.remove(authorInput);
                System.out.println("Author removed");
            }
            else {
                throw new Exception("Author not found");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
    public boolean isMatchItem(Book item){
        return this.id == item.id &&
        this.title.equals(item.getTitle())&& 
        this.category.equals(item.getCategory()) &&
        this.cost == item.cost && 
        this.token == item.token;
    }

}
