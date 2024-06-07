package OtherProject.Week1;

import java.util.Arrays;
import java.util.Scanner;

public class sortArrays {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements of the array: ");
        int sum = 0;
        for(int i = 0; i < n ; i++){
            arr[i] = input.nextInt();
            sum += arr[i];
        }
        Arrays.sort(arr);
        System.out.println("The sorted array: ");
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("Sum is: " + sum + ", and the avarage is: " + sum/n);
    }
}
