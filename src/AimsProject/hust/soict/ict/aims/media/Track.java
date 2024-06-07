package AimsProject.hust.soict.ict.aims.media;


import AimsProject.hust.soict.ict.aims.exception.PlayerException;

import java.util.Objects;

public class Track implements Playable {
    private String title;
    private int length;

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Track that)) return false;
        return Objects.equals(getTitle(), that.getTitle()) && getLength() == that.getLength();
    }

    @Override
    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            System.err.println("ERROR: Track length is non-positive.");
            throw new PlayerException("Track length is non-positive.");
        }
        // Code to play the track
        System.out.println("Playing track: " + this.title);
        System.out.println("Track length: " + this.length);
    }
}
