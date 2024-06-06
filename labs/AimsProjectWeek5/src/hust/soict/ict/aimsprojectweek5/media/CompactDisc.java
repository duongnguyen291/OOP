package ict.aimsprojectweek5.media;
import ict.aimsprojectweek5.Exception.PlayerException;
import java.util.ArrayList;
import javafx.scene.control.Alert;
import ict.aimsprojectweek5.media.*;
import java.util.List;
public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList <Track> trackList = new ArrayList<>();
    private int numberOfSong = 0;
    public  CompactDisc(String title, String category, String director,String artist,int length, float cost) {
        super(title,category,director,length,cost);
        this.artist = artist;
    }
    public  CompactDisc(int id, String title, String category, String director,String artist,int length, float cost) {
        super(id, title,category,director,length,cost);
        this.artist = artist;
    }
    public String getArtist(){
        return artist;
    }

    public void addTrack(Track musicSongInput){
        try{
            for(Track musicSong : trackList){
                if(musicSong.isMatch(musicSongInput)){
                    throw new Exception("This track is already in the CD");
                }
            }
            trackList.add(musicSongInput);
            numberOfSong++;
        }catch (Exception e){
            System.err.println(e.getMessage());
        }


    }
    public void removeTrack(Track musicSongInput){
        try{
            for(int i = 0; i < trackList.size(); i++){
                if(trackList.get(i).isMatch(musicSongInput)){
                    trackList.remove(i);
                    numberOfSong--;
                    return;
                }
            }
            throw new Exception("Track not found in TrackList");
        }catch (Exception e){
            System.err.println(e.getMessage());
        }

           
    }
    public int getLength(){
        int totalLength = 0;
        for(Track track : trackList){
            totalLength+=track.getLength();
        }
        return totalLength;
    }
    public int getTrack(){
        return numberOfSong;
    }
    @Override
    //String title, String category,String director,int length, float cost
    public void toStringItem(int order){
        System.out.println(order + ".CompactDisc - " + this.getTitle() + " - " + this.getCategory()+ " - " + this.getDirector() +  " - " + this.getArtist() + " - " + this.getLength()+ " - " + this.getCost() + " $");
    }
    public boolean isMatchItem(CompactDisc item){
        return this.id == item.id &&
        this.title.equals(item.getTitle())&& 
        this.category.equals(item.getCategory()) &&
        this.cost == item.cost && 
        this.director.equals(item.getDirector()) && 
        this.length == item.length && 
        this.artist.equals(item.getArtist());
    }
    public void play() throws PlayerException {
        try {
            if(this.getLength() > 0) {
                java.util.Iterator iter = trackList.iterator();
                Track nextTrack;
                while (iter.hasNext()) {
                    nextTrack = (Track) iter.next();
                    try {
                        nextTrack.play();
                    } catch (PlayerException e) {
                        throw e;

                    }
                }

            } else {
                throw new PlayerException("ERROR: CD length is non-positive!");
            }
        } catch (PlayerException e) {
            System.err.println(e.getMessage());
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Error");
            alert.setHeaderText(e.getMessage());
            alert.showAndWait();
        }
    }
}
