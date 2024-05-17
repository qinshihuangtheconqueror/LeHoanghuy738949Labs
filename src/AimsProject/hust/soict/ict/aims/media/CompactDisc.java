package AimsProject.hust.soict.ict.aims.media;

import java.util.ArrayList;
import java.util.List;


public class CompactDisc extends Disc implements Playable{
    private String artist;
    private List<Track> tracks = new ArrayList<Track>();

    public List<String> gettrackName(){
        List<String> tracksName = new ArrayList<String>();
        for(Track track : tracks){
            tracksName.add(track.getTitle());
        }
        return tracksName;
    }

    public CompactDisc(String title, String category, float cost, String director, String artist) {
        super(title, category, cost, director);
        this.artist = artist;
    }

    public CompactDisc(int id, String title, String category, float cost, String director, String artist) {
        super(id, title, category, cost, director);
        this.artist = artist;
    }

    public CompactDisc() {
    }


    public String getArtist() {
        return artist;
    }

    public void addTrack(Track trackName){
        if(!tracks.contains(trackName)){
            tracks.add(trackName);
        }
        else{
            System.out.println("The track is already in the list");
        }
    }
    public void removeTrack(Track trackName){
        if(tracks.contains(trackName)){
            tracks.remove(trackName);
        }
        else{
            System.out.println("The track is not in the list");
        }
    }

    @Override
    public int getLength(){
        int totalLength = 0;
        for(int i = 0; i < tracks.size(); i++){
            totalLength += tracks.get(i).getLength();
        }
        return totalLength;
    }
    @Override
    public void play() {
        for(int i = 0; i < tracks.size(); i++){
            tracks.get(i).play();
        }
    }

    @Override
    public String toString() {
        return "CD: " + super.toString() + " - " + getLength() + " - " + getArtist() + gettrackName();
    }
}
