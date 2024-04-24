package aims.media;
import java.util.ArrayList;

public class Book extends Media{

    private int token;
    private ArrayList<String>  listOfAuthors  = new ArrayList<>();


    public Book(int id, String title, String category, String author, double cost, int token){
        super(id, title,category, cost);
        this.token = token;
        this.listOfAuthors.add(author);
    }
    public Book(int id, String title, String category, double cost, int token){
        super(id, title,category, cost);
        this.token = token;
    }
    public Book(String title, String category, double cost, int token){
        super(title,category, cost);
        this.token = token;

    }
    public int getToken(){
        return token;
    }
    @Override
    // String title, String category, double cost, int token
    public void toStringItem(int order){
        System.out.println(order + ".Book - " +  this.getTitle()+ " - " + this.getCategory()  + " - " + this.getToken() + " - " + this.getCost() + " $");
    }
    public void addAuthor(String authorInput){
        for(String author : listOfAuthors){
            if(author.equals(authorInput)){
                System.out.println("This author is already in the list");
                return;
            }
        }
        listOfAuthors.add(authorInput); 
    }
    public void removeAuthor(String authorInput){
        for(int i = 0; i < listOfAuthors.size(); i++){
            if(listOfAuthors.get(i).equals(authorInput)){
                listOfAuthors.remove(i);
                return;
            }
        }
        System.out.println("Song not found in TrackList");
            
    }
    public boolean isMatchItem(Book item){
        return this.id == item.id &&
        this.title.equals(item.getTitle())&& 
        this.category.equals(item.getCategory()) &&
        this.cost == item.cost && 
        this.token == item.token;
    }
}
