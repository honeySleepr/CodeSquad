package cocoa.day1;

import java.util.Scanner;

public class if14681 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        while (x < -1000 || x > 1000 || x == 0) {
            System.out.println("x값 새로 입력");
            sc = new Scanner(System.in);
            x = sc.nextInt();
        }
        while (y < -1000 || y > 1000 || y == 0) {
            System.out.println("y값 새로 입력");
            sc = new Scanner(System.in);
            y = sc.nextInt();
        }
        if (x > 0) {
            if (y > 0) {
                System.out.println("1");
            }
            if (y < 0) {
                System.out.println("4");
            }
        }
        if (x < 0) {
            if (y > 0) {
                System.out.println("2");
            }
            if (y < 0) {
                System.out.println("3");
            }
        }

    }
}
