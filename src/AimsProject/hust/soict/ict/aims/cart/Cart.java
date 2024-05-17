package AimsProject.hust.soict.ict.aims.cart;

import AimsProject.hust.soict.ict.aims.media.Media;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Media> itemsOrdered = new ArrayList<Media>();

    public List<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public void addMedia(Media media){
        if(!itemsOrdered.contains(media)){
            itemsOrdered.add(media);
        }
        else {
            System.out.println("The item is already in the ordered list");
        }
    }

    public void removeMedia(Media media){
        if(itemsOrdered.contains(media)){
            itemsOrdered.remove(media);
        }
        else {
            System.out.println("The item is not in the ordered list");
        }
    }
    public float totalCost(){
        float totalPrice = 0;
        for(int i = 0; i < itemsOrdered.size(); i++){
            totalPrice += this.itemsOrdered.get(i).getCost();
        }
        return totalPrice;
    }

    public void print(){
        System.out.println("*****************Cart**************");
        System.out.println("Ordered Items");
        for(int i = 0; i < itemsOrdered.size(); i++){
            System.out.println((i + 1) + "." + this.itemsOrdered.get(i).toString());
        }
        System.out.printf("Total cost: %.2f ", totalCost());
        System.out.println();
        System.out.println("************************************");
    }

    public void SearchbyTitle(String title){
        int count = 0;
        for(int i = 0; i < this.itemsOrdered.size(); i++){
            if(this.itemsOrdered.get(i).isMatch(title)){
                count++;
                System.out.println(this.itemsOrdered.get(i).toString());
            }
        }
        if(count == 0) System.out.println("No items found");
    }
    public Media searchTitle(String title) {
        Media item = null;
        for (int i=0;i<itemsOrdered.size(); i++) {
            if (itemsOrdered.get(i).isMatch(title)) {
                return itemsOrdered.get(i);
            }
        }
        System.out.println("No items found");
        return item;
    }

    public Media searchId(int Id) {
        Media item = null;
        for (int i=0;i<itemsOrdered.size(); i++) {
            if (itemsOrdered.get(i).getId() == Id) {
                return itemsOrdered.get(i);
            }
        }
        System.out.println("No items found");
        return item;
    }
}