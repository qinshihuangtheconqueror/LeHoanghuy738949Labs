package OtherProject.Week2;

public class AIMS {
    public static void main(String[] args) {
        //Create a new cart
        Cart anOrder = new Cart();

        //Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star War", "Science Fiction", "Geoger Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);

        //Remove a disc form cart
        anOrder.removeDigitalVideoDisc(dvd2);
//        anOrder.removeDigitalVideoDisc(dvd3);
        //print total cost of the items in the cart
        System.out.printf("Total cost is: %.2f ", anOrder.totalCost());
    }
}
