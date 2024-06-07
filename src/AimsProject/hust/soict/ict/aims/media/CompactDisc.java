package AimsProject.hust.soict.ict.aims.media;

import AimsProject.hust.soict.ict.aims.exception.PlayerException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompactDisc extends Disc implements Playable{

    private String artist;
    private List<Track> tracks = new ArrayList<Track>();

    public List<Track> getTracks() {
        return tracks;
    }

    public List<String> gettrackName(){
        List<String> tracksName = new ArrayList<String>();
        for(Track track : tracks){
            tracksName.add(track.getTitle());
        }
        return tracksName;
    }

    public CompactDisc(int id, String title, String category, float cost, String artist, List<Track> tracks) {
        super(id, title, category, cost);
        this.artist = artist;
        this.tracks = tracks;
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
    public void play() throws PlayerException {
        if(this.getLength() > 0){
            Iterator iter = tracks.iterator();
            Track nextTrack;
            while (iter.hasNext()){
                nextTrack = (Track) iter.next();
                try{
                    nextTrack.play();
                }
                catch (PlayerException e){
                    throw e;
                }
            }
        }
        else {
            throw new PlayerException("ERROR: CD length is non-positive!");
        }
    }

    @Override
    public String toString() {
        return "CD: " + super.toString() + " - " + getLength() + " - " + getArtist() + " - " + gettrackName();
    }
}
