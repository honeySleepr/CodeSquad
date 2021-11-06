package cocoa.day1;

import java.util.Scanner;

public class if2753 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        while (year < 1 || year > 4000) {
            sc = new Scanner(System.in);
            year = sc.nextInt();
        }
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            System.out.println("1");
        } else {
            System.out.println("0");

        }


    }
}
