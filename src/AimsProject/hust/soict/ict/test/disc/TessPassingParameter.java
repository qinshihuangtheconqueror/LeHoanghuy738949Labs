package AimsProject.hust.soict.ict.test.disc;

import AimsProject.hust.soict.ict.aims.media.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TessPassingParameter {
    public static void main(String[] args) {
        List<Media> mediae = new ArrayList<Media>();

        Book book1 = new Book(1, "Title 1", "Category 1", 70);
        book1.addAuthor("Author 1");
        book1.addAuthor("Author 3");

        List<String> authorList = new ArrayList<String>();
        authorList.add("Author 1");
        authorList.add("Author 2");
        Book book2 = new Book(1, "Title 1", "Category 1", 80, "Author 1", "Author 2");
        book2.addAuthor("Author 3");

        mediae.add((Media) book1);
        mediae.add((Media) book2);

        DigitalVideoDisc dvd1 = new DigitalVideoDisc(2, "The Lion King", "Animation", 19.95f, 87, "Roger Allers");

        mediae.add((Media) dvd1);

        CompactDisc cd1 = new CompactDisc(3, "Title 1", "Category 1", 19.88f, "Director 1", "Artist 1");
        Track track1 = new Track("Track1", 50);
        cd1.addTrack(track1);
        Track track2 = new Track("Track2", 40);
        cd1.addTrack(track2);
        Track track3 = new Track("Track3", 20);
        cd1.addTrack(track3);

        mediae.add((Media) cd1);

        for(Media m : mediae){
            System.out.println(m.toString());
        }

        DigitalVideoDisc media = new DigitalVideoDisc("Title 1");
        System.out.println(media.isMatch("Title 1"));
    }
}
