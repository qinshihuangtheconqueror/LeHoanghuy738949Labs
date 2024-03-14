package Lab01;

import java.util.Scanner;
public class InputFromKeyboard {
    public static void main(String args[]){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What's your name ?");
        String strName = keyboard.nextLine();
        int iAge = keyboard.nextInt();
        System.out.println("How tall are you (m) ?");
        double dHeight = keyboard.nextDouble();
        System.out.println("Mrs/Ms. "+strName+ ", "+iAge+" years old."+ "Your Height is "+dHeight+".");

    }
}
