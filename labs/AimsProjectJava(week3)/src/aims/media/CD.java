package aims.media;
import java.util.ArrayList;
public class CD {
    private String title;
    private String category;
    private String artist;
    private String director;
    private double cost;
    private int length;
    private ArrayList <Track> trackList = new ArrayList<>();
    private int numberOfSong = 0;

    public CD(String title, String category, String artist, String director, double cost,int length){
        this.title = title;
        this.category = category;
        this.artist = artist;
        this.director = director;
        this.cost = cost;
        this.length = length;
    }
    public CD(String title, String category, String artist, String director, double cost){
        this.title = title;
        this.category = category;
        this.artist = artist;
        this.director = director;
        this.cost = cost;
    }
    public CD(String title, String category, String artist, double cost){
        this.title = title;
        this.category = category;
        this.artist = artist;
        this.cost = cost;
    }
    public void addSong(Track musicSongInput){
        for(Track musicSong : trackList){
            if(musicSong.isMatch(musicSongInput)){
                System.out.println("This song is already in the CD");
                return;
            }
        }
        trackList.add(musicSongInput); 
        numberOfSong++;

    }
    public void removeSong(Track musicSongInput){
        boolean found = false;
        for(int i = 0; i < trackList.size(); i++){
            if(trackList.get(i).isMatch(musicSongInput)){
                trackList.remove(i);
                numberOfSong--;
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println("Song not found in TrackList");
        }      
    }

    public CD(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
    public String getCategory() {
        return category;
    }
    public String getDirector() {
        return director;
    }
    public String getArtist() {
        return artist;
    }
    public double getCost() {
        return cost;
    }
    public int getLength() {
        return length;
    }
    public int getNumberOfSong() {
        return numberOfSong;
    }
    public void toString(int order){
        System.out.println(order + ".CD - " +  this.getTitle()+ " - " + this.getCategory() + " - "  + this.getArtist() + " " + this.getDirector() + " " + this.getLength()+ " - " + this.getCost() + " $");
    }
}
