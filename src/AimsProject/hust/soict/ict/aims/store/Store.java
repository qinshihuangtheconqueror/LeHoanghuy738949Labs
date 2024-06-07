package AimsProject.hust.soict.ict.aims.store;

import AimsProject.hust.soict.ict.aims.media.*;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }

    public void addMedia(Media media){
        if(!itemsInStore.contains(media)){
            itemsInStore.add(media);
        }
    }

    public void removeMedia(Media media){
        if(itemsInStore.contains(media)){
            itemsInStore.remove(media);
        }
    }

    public void print(){
        System.out.println("The available media in the store is: ");
        for(int i = 0; i < itemsInStore.size(); i++){
            System.out.println(itemsInStore.get(i).toString());
        }
        System.out.println("--------------------------------------");
    }


    public Media searchTitle(String title) {
        Media item = null;
        for (int i=0;i<itemsInStore.size(); i++) {
            if (itemsInStore.get(i).isMatch(title)) {
                return itemsInStore.get(i);
            }
        }
        return item;
    }
    public void initData() {
        // Khởi tạo sách
        addMedia(new Book(1, "Java Programming", "Education", 25.0f, "John Smith"));
        addMedia(new Book(2, "Python Basics", "Education", 20.0f, "Alice Johnson"));
        addMedia(new Book(3, "Data Structures", "Education", 30.0f, "David Lee"));
        addMedia(new Book(4, "Algorithms", "Education", 28.0f, "Emily Wang"));
        addMedia(new Book(5, "Machine Learning", "Education", 35.0f, "Michael Brown"));
        addMedia(new Book(6, "History of Art", "History", 18.0f, "Sophia Davis"));
        addMedia(new Book(7, "World War II", "History", 22.0f, "William Wilson"));
        addMedia(new Book(8, "Ancient Civilizations", "History", 26.0f, "Olivia Martinez"));
        addMedia(new Book(9, "Literature Classics", "Literature", 32.0f, "Ethan Taylor"));
        addMedia(new Book(10, "Modern Poetry", "Literature", 15.0f, "Ava Anderson"));

        // Khởi tạo DigitalVideoDisc
        addMedia(new DigitalVideoDisc(1, "The Matrix", "Action", 15.0f, 120, "The Wachowskis"));
        addMedia(new DigitalVideoDisc(2, "Inception", "Sci-Fi", 12.0f, 148, "Christopher Nolan"));
        addMedia(new DigitalVideoDisc(3, "Forrest Gump", "Drama", 10.0f, 0, "Robert Zemeckis"));
        addMedia(new DigitalVideoDisc(4, "The Godfather", "Crime", 14.0f, 175, "Francis Ford Coppola"));
        addMedia(new DigitalVideoDisc(5, "Pulp Fiction", "Crime", 11.0f, 154, "Quentin Tarantino"));
        addMedia(new DigitalVideoDisc(6, "The Shawshank Redemption", "Drama", 13.0f, 142, "Frank Darabont"));
        addMedia(new DigitalVideoDisc(7, "The Dark Knight", "Action", 14.5f, 152, "Christopher Nolan"));


        // Khởi tạo 5 CompactDisc
        List<Track> tracks1 = new ArrayList<>();
        tracks1.add(new Track("Song 1", 0));
        tracks1.add(new Track("Song 2", 0));
        tracks1.add(new Track("Song 3", 0));
        CompactDisc cd1 = new CompactDisc(1, "Album A", "Pop", 12.0f, "Singer A", tracks1);
        addMedia(cd1);

        List<Track> tracks2 = new ArrayList<>();
        tracks2.add(new Track("Track 1", 4));
        tracks2.add(new Track("Track 2", 0));
        tracks2.add(new Track("Track 3", 3));
        CompactDisc cd2 = new CompactDisc(2, "Album B", "Rock", 14.0f, "Singer B", tracks2);
        addMedia(cd2);

        List<Track> tracks3 = new ArrayList<>();
        tracks3.add(new Track("Jazz 1", 4));
        tracks3.add(new Track("Jazz 2", 5));
        tracks3.add(new Track("Jazz 3", 3));
        CompactDisc cd3 = new CompactDisc(3, "Album C", "Jazz", 16.0f, "Singer C", tracks3);
        addMedia(cd3);

        List<Track> tracks4 = new ArrayList<>();
        tracks4.add(new Track("Hip-hop 1", 4));
        tracks4.add(new Track("Hip-hop 2", 5));
        tracks4.add(new Track("Hip-hop 3", 3));
        CompactDisc cd4 = new CompactDisc(4, "Album D", "Hip-hop", 13.0f, "Singer D", tracks4);
        addMedia(cd4);

        List<Track> tracks5 = new ArrayList<>();
        tracks5.add(new Track("Classical 1", 4));
        tracks5.add(new Track("Classical 2", 5));
        tracks5.add(new Track("Classical 3", 3));
        CompactDisc cd5 = new CompactDisc(5, "Album E", "Classical", 18.0f, "Singer E", tracks5);
        addMedia(cd5);

    }
}
