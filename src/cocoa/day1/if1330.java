package cocoa.day1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class if1330 {
    public static void main(String[] args) {
//        BufferedReader buf = new BufferedReader((new InputStreamReader(System.in)));

        Scanner num = new Scanner(System.in);

        int num1 = num.nextInt();
        int num2 = num.nextInt();
while(num1 < -100 || num1 >100){

}
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
