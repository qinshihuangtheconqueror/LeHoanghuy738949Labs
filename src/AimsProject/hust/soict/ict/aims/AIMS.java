package AimsProject.hust.soict.ict.aims;

import AimsProject.hust.soict.ict.aims.cart.Cart;
import AimsProject.hust.soict.ict.aims.exception.CartFullException;
import AimsProject.hust.soict.ict.aims.media.*;
import AimsProject.hust.soict.ict.aims.store.Store;

import javax.naming.LimitExceededException;
import java.util.List;
import java.util.Scanner;

public class AIMS {
    public static Cart order = new Cart();
    public static List<Media> itemsinOrdered = order.getItemsOrdered();
    public static Store store = new Store();
    public static List<Media> itemsInstore = store.getItemsInStore();
    public static Scanner input = new Scanner(System.in);

    public static void showMenu(){
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }
    public static void storeMenu() {

        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");

    }
    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    public static void cartOption() throws LimitExceededException, CartFullException {
        int choice;
        do {
            cartMenu();
            System.out.println("Your choice is: ");
            choice = input.nextInt();
        }
        while(choice > 5 || choice < 0);
        switch (choice){
            case 1: {
                order.print();
                System.out.println("Choosing option: ");
                System.out.println("1: Filter by id");
                System.out.println("2: Filter by title");
                int number = input.nextInt();
                if(number == 1){
                    System.out.println("Enter the id: ");
                    int id = input.nextInt();
                    Media searchedMedia = order.searchId(id);
                    if(searchedMedia != null){
                        System.out.println(searchedMedia.toString());
                    }
                }
                else if(number == 2){
                    System.out.println("Enter the title: ");
                    input.nextLine();
                    String title = input.nextLine();
                    Media searchedMedia = order.searchTitle(title);
                    if(searchedMedia != null){
                        System.out.println(searchedMedia.toString());
                    }
                }
                else System.out.println("Valid choice");
                cartOption();
                break;
            }
            case 2: {
                System.out.println("Choosing option: ");
                System.out.println("1: Sort by title");
                System.out.println("2: Sort by cost");
                int number = input.nextInt();
                if(number == 1){
                    itemsinOrdered.sort(Media.COMPARE_BY_TITLE_COST);
                    order.print();
                }
                else if(number == 2){
                    itemsinOrdered.sort(Media.COMPARE_BY_COST_TITLE);
                    order.print();
                }
                else {
                    System.out.println("Valid selection");
                }
                cartOption();
                break;
            }
            case 3: {
                order.print();
                System.out.println("Enter the media title you want to remove: ");
                input.nextLine();
                String title = input.nextLine();
                Media searchedTitle = order.searchTitle(title);
                order.removeMedia(searchedTitle);
                order.print();
                choosingOption();
                break;
            }

            case 4: {
                System.out.println("Enter the title: ");
                input.nextLine();
                String title = input.nextLine();
                Media searchedTitle = order.searchTitle(title);
                playMedia(searchedTitle);
                cartOption();
                break;
            }
            case 5: {
                System.out.println("An order is created. Please check your email to confirm the order");
                order.print();
                itemsinOrdered.clear();
            }
            case 0: {
                choosingOption();
            }
        }
    }
    public static void detailOption(Media chosenMedia) throws CartFullException, LimitExceededException {
        int choice;
        do {
            mediaDetailsMenu();
            System.out.print("Your choice is: ");
            choice = input.nextInt();
        }
        while(choice > 2 || choice < 0);
        switch (choice){
            case 1: {
                order.addMedia(chosenMedia);
                choosingOption();
                break;
            }
            case 2: {
                boolean checkedError = true;
                try {
                    CompactDisc chosenDVD = (CompactDisc) chosenMedia;
                    chosenDVD.play();
                    checkedError = false;
                }
                catch (Exception e){

                }
                try {
                    DigitalVideoDisc chosenDVD = (DigitalVideoDisc) chosenMedia;
                    chosenDVD.play();
                    checkedError = false;
                }
                catch (Exception e){

                }
                if (checkedError){
                    System.out.println("The chosen media is not a CD or DVD");
                    break;
                }
                choosingOption();
                break;
            }
            case 0: {
                choosingOption();
            }
        }
    }
    public static void seeAMediaDetail(Media searchTitle) throws LimitExceededException, CartFullException {
        int choice;
        do {
            mediaDetailsMenu();
            System.out.println("Enter your choice: ");
            choice = input.nextInt();
        } while (choice > 2 || choice < 0);
        switch (choice){
            case 1: {
                order.addMedia(searchTitle);
                order.print();
                choosingOption();
                break;
            }
            case 2: {
                playMedia(searchTitle);
                choosingOption();
                break;
            }
            case 0: {
                choosingOption();
                break;
            }
        }
    }
    public static void playMedia(Media searchTitle){
        boolean isDVD = false;
        boolean isCD = false;
        try {
            CompactDisc chosenMedia = (CompactDisc) searchTitle;
            chosenMedia.play();
            isCD = true;
        }
        catch (Exception e){

        }
        try {
            DigitalVideoDisc chosenMedia = (DigitalVideoDisc) searchTitle;
            chosenMedia.play();
            isDVD = true;
        }
        catch (Exception e){

        }
        if (!isCD && !isDVD){
            System.out.println("The chosen media is not a CD or DVD \n");
        }
    }
    public static void choosingOption() throws LimitExceededException, CartFullException {
        int choice;
        do {
            storeMenu();
            System.out.print("Your choice is: ");
            choice = input.nextInt();
        }
        while(choice > 4 || choice < 0);
        switch (choice){
            case 1: {
                store.print();
                System.out.print("Enter the media title: ");
                input.nextLine();
                String title = input.nextLine();
                Media searchedMedia = store.searchTitle(title);
                if(searchedMedia != null){
                    seeAMediaDetail(searchedMedia);
                }
                else{
                    System.out.println("No valid media");
                    choosingOption();
                }
                break;
            }
            case 2: {
                store.print();
                System.out.print("Enter the media title: ");
                input.nextLine();
                String title = input.nextLine();
                Media searchedMedia = store.searchTitle(title);
                if (searchedMedia.getTitle() != null){
                    order.addMedia(searchedMedia);
                }
                order.print();
                choosingOption();
                break;
            }
            case 3: {
                store.print();
                System.out.println("Enter the title: ");
                input.nextLine();
                String title = input.nextLine();
                Media searchedMedia = store.searchTitle(title);
                if (searchedMedia.getTitle() != null){
                    playMedia(searchedMedia);
                }
                choosingOption();
                break;
            }
            case 4: {
                order.print();
                cartOption();
                break;
            }
            case 0: {
                menuOption();
                break;
            }
        }
    }
    public static void addBooktoStore(){
        String breakpoint = "";
        System.out.println("Enter Book id: ");
        int id = input.nextInt();
        System.out.println("Enter Book title: ");
        input.nextLine();
        String title = input.nextLine();
        System.out.println("Enter Book category: ");
        String category = input.nextLine();
        System.out.println("Enter Book cost: ");
        float cost = input.nextFloat();
        System.out.println("Enter authors: ");
        input.nextLine();
        Book book = new Book (id, title, category, cost);

        while (!breakpoint.equals("#")){
            System.out.println("Enter author name: ");
            String authorName = input.nextLine();
            book.addAuthor(authorName);
            System.out.println("Enter anything to continue adding, enter # to end adding");
            breakpoint = input.nextLine();
        }

        store.addMedia(book);

    }
    public static void addDVDtoStore(){
        System.out.println("Enter DVD id: ");
        int id = input.nextInt();
        System.out.println("Enter DVD title: ");
        input.nextLine();
        String title = input.nextLine();
        System.out.println("Enter DVD category: ");
        String category = input.nextLine();
        System.out.println("Enter DVD cost: ");
        float cost = input.nextFloat();
        System.out.println("Enter DVD length: ");
        int length = input.nextInt();
        System.out.println("Enter DVD director: ");
        input.nextLine();
        String director = input.nextLine();

        DigitalVideoDisc dvd = new DigitalVideoDisc(id, title, category, cost, length, director);
        store.addMedia(dvd);
    }
    public static void addCDtoStore(){
        String breakpoint = "";
        System.out.println("Enter CD id: ");
        int id = input.nextInt();
        System.out.println("Enter CD title: ");
        input.nextLine();
        String title = input.nextLine();
        System.out.println("Enter CD category: ");
        String category = input.nextLine();
        System.out.println("Enter CD cost: ");
        float cost = input.nextFloat();
        System.out.println("Enter CD director: ");
        input.nextLine();
        String director = input.nextLine();
        System.out.println("Enter CD artist: ");
        String artist = input.nextLine();
        System.out.println("Enter track list: ");

        CompactDisc cd = new CompactDisc(id, title, category, cost, director, artist);

        while (!breakpoint.equals("#")){
            System.out.println("Enter track name: ");
            String trackName = input.nextLine();
            System.out.println("Enter track length: ");
            int trackLength = input.nextInt();
            Track track = new Track(trackName, trackLength);
            cd.addTrack(track);
            System.out.println("Enter anything to continue adding, enter # to end adding");
            input.nextLine();
            breakpoint = input.nextLine();
        }

        store.addMedia(cd);

    }
    public static void updateOption() throws LimitExceededException, CartFullException {
        System.out.println("Update options: ");
        System.out.println("1. Add");
        System.out.println("2. Remove");
        System.out.println("Select the option: ");
        int choice = input.nextInt();
        if(choice == 1){
            System.out.println("Select the type of media: ");
            System.out.println("1. Book");
            System.out.println("2. DVD");
            System.out.println("3. CD");
            int mediaChoice = input.nextInt();
            switch (mediaChoice){
                case 1: {
                    addBooktoStore();
                    store.print();
                    menuOption();
                    break;
                }
                case 2: {
                    addDVDtoStore();
                    store.print();
                    menuOption();
                    break;
                }
                case 3: {
                    addCDtoStore();
                    store.print();
                    menuOption();
                    break;
                }
            }
        }
        else if(choice == 2){
            store.print();
            System.out.println("Enter media title: ");
            input.nextLine();
            String inputTitle = input.nextLine();
            Media searchedMedia = store.searchTitle(inputTitle);
            store.removeMedia(searchedMedia);
            store.print();
            menuOption();
        }
    }
    public static void menuOption() throws LimitExceededException, CartFullException {
        int choice;
        do {
            showMenu();
            System.out.print("Your choice is: ");
            choice = input.nextInt();
        }
        while(choice > 3 || choice < 0);

        switch (choice){
            case 1: {
                choosingOption();
                break;
            }
            case 2: {
                updateOption();
                break;
            }
            case 3: {
                order.print();
                cartOption();
                break;
            }
            case 0: break;
        }

    }
    public static void main(String[] args) throws LimitExceededException, CartFullException {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, 87, "Roger Allers");
        store.addMedia((Media) dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star War", "Science Fiction", 24.95f, 87, "Geoger Lucas");
        store.addMedia((Media) dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Aladin", "Animation", 18.99f);
        store.addMedia((Media) dvd3);
        Book book1 = new Book(1, "Book 1", "Category 1", 40.26f);
        store.addMedia((Media) book1);
        Scanner input = new Scanner(System.in);
        menuOption();
    }
}

