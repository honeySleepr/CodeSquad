package BaekJoon;

import java.util.Scanner;

public class BJ2439 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num - 1-i; j++) {
                System.out.print(" ");
            }
            int n = i+1;
            while (n > 0) {
                System.out.print("*");
                n--;
            }
            System.out.println();
        }

    }
}
