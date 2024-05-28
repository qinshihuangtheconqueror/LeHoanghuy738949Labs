package AimsProject.src.hust.soict.globalict.test.disc;

import AimsProject.src.hust.soict.globalict.aims.media.DigitalVideoDisc;

public class TestPassingParameter {
    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
        swap(jungleDVD, cinderellaDVD);
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    }

    /**
     * "It doesn't work."
     *
     * The reason it doesn't work is because the variables o1 and o2 are local variables
     *
     * @param o1 The first object to swap.
     * @param o2 [1, 2, 3, 4, 5]
     */
    public static void swap(Object o1, Object o2){
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }
    /**
     * ChangeTitle() changes the title of the DVD passed to it, but it also creates a new DVD with the old title.
     *
     * @param dvd a reference to a hust.soict.ict.aims.media.DigitalVideoDisc object
     * @param title The title of the DVD.
     */
    public static void changeTitle(DigitalVideoDisc dvd, String title){
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }
}
