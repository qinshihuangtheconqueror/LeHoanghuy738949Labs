package AimsProject.hust.soict.ict.aims.store;

import AimsProject.hust.soict.ict.aims.media.Media;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Media> itemsInStore = new ArrayList<Media>();

    public List<Media> getItemsInStore() {
        return itemsInStore;
    }

    public void addMedia(Media media){
        if(!itemsInStore.contains(media)){
            itemsInStore.add(media);
            System.out.println("The media has been added");
        }
        else System.out.println("The media is already in the store");
    }

    public void removeMedia(Media media){
        if(itemsInStore.contains(media)){
            itemsInStore.remove(media);
            System.out.println("The media has been removed");
        }
        else System.out.println("No disc found");
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
}
