package aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList <Track> trackList = new ArrayList<>();
    private int numberOfSong = 0;
    public  CompactDisc(String title, String category, String director,String artist,int length, double cost) {
        super(title,category,director,length,cost);
        this.artist = artist;
    }
    public String getArtist(){
        return artist;
    }
    public void play(){
        System.out.println("=======START PLAY TRACKS LIST=======");
        for(Track track: trackList){
            track.play();
        }
    }
    public void addTrack(Track musicSongInput){
        for(Track musicSong : trackList){
            if(musicSong.isMatch(musicSongInput)){
                System.out.println("This track is already in the CD");
                return;
            }
        }
        trackList.add(musicSongInput); 
        numberOfSong++;

    }
    public void removeTrack(Track musicSongInput){
        for(int i = 0; i < trackList.size(); i++){
            if(trackList.get(i).isMatch(musicSongInput)){
                trackList.remove(i);
                numberOfSong--;
                return;
            }
        }
        System.out.println("Track not found in TrackList");
           
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
    //String title, String category,String director,int length, double cost
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
}
