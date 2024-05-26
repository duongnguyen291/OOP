package aims.media;

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

    public void play(){
        System.out.println("Playing Track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
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
