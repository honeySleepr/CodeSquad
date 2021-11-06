package cocoa.day1;

import java.util.Scanner;

public class if1330 {
    public static void main(String[] args) {

        Scanner num = new Scanner(System.in);

        int num1 = num.nextInt();
        int num2 = num.nextInt();

        if (num1 > num2) {
            System.out.println(">");
        }
        if (num1 < num2) {
            System.out.println("<");
        }
        if (num1 == num2) {
            System.out.println("==");
        }
    }
//git테스트
}
