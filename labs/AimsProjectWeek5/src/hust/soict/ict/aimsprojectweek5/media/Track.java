package ict.aimsprojectweek5.media;
import javafx.scene.control.Alert;
import ict.aimsprojectweek5.Exception.PlayerException;
public class Track implements Playable{
    private String title;
    private int length;
    
    public Track(String title, int length){
        this.title = title;
        this.length = length;
    }
    public Track(String title){
        this.title = title;
    }

    public void play() throws PlayerException {
        try {
            if(this.length > 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Play");

                // Header Text: null
                alert.setHeaderText(null);
                alert.setContentText("Playing " + this.getTitle() + "!");

                alert.showAndWait();
            } else {
                throw new PlayerException("ERROR: DVD length is non-positive!");
            }
        } catch (PlayerException e) {
            System.err.println(e.getMessage());
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Error");
            alert.setHeaderText(e.getMessage());
            alert.showAndWait();
        }
    }
    public String getTitle() {
        return title;
    }
    public int getLength() {
        return length;
    }
    public boolean isMatch(Track itemSong){
        return this.getTitle() == itemSong.getTitle() && this.getLength() == itemSong.getLength();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Track track = (Track) o;
        return length == track.length && title.equals(track.title);
    }
}   
