package ict.aimsprojectweek5.media;
import ict.aimsprojectweek5.Exception.PlayerException;
import java.util.ArrayList;
import javafx.scene.control.Alert;
public class DigitalVideoDisc extends Disc implements Playable{
    public DigitalVideoDisc(String title, String category,String director,int length, float cost) {
        super(title,category,director,length,cost);
    }
    public DigitalVideoDisc(int id, String title, String category,String director,int length, float cost) {
        super(id, title,category,director,length,cost);
    }

    @Override
    public void toStringItem(int order){
        System.out.println(order + ".CD - " +  this.getCategory()+ " - " + this.getDirector() + " - " + this.getLength()+ " - " + this.getCost() + " $");
    }
    public boolean isMatchTitle(String title){
        return this.getTitle() == title;
    }
    public boolean isMatchItem(DigitalVideoDisc item){
        return this.id == item.id &&
        this.title.equals(item.getTitle())&& 
        this.category.equals(item.getCategory()) &&
        this.cost == item.cost && 
        this.director.equals(item.getDirector()) && 
        this.length == item.length;
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

}
