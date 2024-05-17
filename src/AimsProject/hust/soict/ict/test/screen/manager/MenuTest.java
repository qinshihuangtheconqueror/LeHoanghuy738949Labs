package AimsProject.hust.soict.ict.test.screen.manager;

import AimsProject.hust.soict.ict.aims.media.Book;
import AimsProject.hust.soict.ict.aims.media.CompactDisc;
import AimsProject.hust.soict.ict.aims.media.DigitalVideoDisc;
import AimsProject.hust.soict.ict.aims.media.Track;
import AimsProject.hust.soict.ict.aims.screen.manager.StoreManagerScreen;
import AimsProject.hust.soict.ict.aims.store.Store;

public class MenuTest {
    public static void main(String[] args) {
        Store store = new Store();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, 87, "Roger Allers");
        store.addMedia(dvd1);
        DigitalVideoDisc dvd6 = new DigitalVideoDisc(6, "The Lion King 2", "Animation", 19.12f, 56, "Roger Allers");
        store.addMedia(dvd6);
        DigitalVideoDisc dvd7 = new DigitalVideoDisc(7, "The Lion King 3", "Animation", 19f, 90, "Roger Allers");
        store.addMedia(dvd7);
        DigitalVideoDisc dvd8 = new DigitalVideoDisc(8, "The Lion King 4", "Animation", 19.6f, 93, "Roger Allers");
        store.addMedia(dvd8);
        CompactDisc cd2 = new CompactDisc(2, "Star Wars", "Science Friction", 24.95f, "Director 1", "Artist 1");
        CompactDisc cd4 = new CompactDisc(4, "Star Wars 2", "Science Friction", 18.99f, "Director 2", "Artist 2");
        CompactDisc cd9 = new CompactDisc(9, "Star Wars 3", "Science Friction", 18.9f, "Director 3", "Artist 3");
        Track track1 = new Track("Track1", 50);
        cd2.addTrack(track1);
        Track track2 = new Track("Track2", 40);
        cd2.addTrack(track2);
        Track track3 = new Track("Track3", 20);
        cd2.addTrack(track3);
        cd4.addTrack(track3);
        cd9.addTrack(track1);
        store.addMedia(cd2);
        store.addMedia(cd4);
        store.addMedia(cd9);
        Book book3 = new Book(3, "Aladin", "Animation", 18.99f);
        Book book5 = new Book(5, "Aladin 2", "Animation", 15.32f, "Author 3", "Author 4");
        Book book10 = new Book(10, "Aladin 37", "Animation", 15.2f, "Author 4");
        Book book11 = new Book(11, "Aladin 36", "Animation", 15.2f, "Author 7");
        Book book12 = new Book(12, "Aladin 5", "Animation", 15.2f, "Author 4z");
        Book book13 = new Book(13, "Aladin 4", "Animation", 15.2f, "Author 44");
        Book book14 = new Book(14, "Aladin 3", "Animation", 15.2f, "Author 4564");
        book3.addAuthor("Author 1");
        book5.addAuthor("Author 2");
        store.addMedia(book3);
        store.addMedia(book5);
        store.addMedia(book10);
        store.addMedia(book11);
        store.addMedia(book12);
        store.addMedia(book13);
        store.addMedia(book14);
        new StoreManagerScreen(store);
    }
}
