package cocoa.day1;

import java.util.Scanner;

public class B11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String num2 = sc.next();

        int sum = 0;
        for(int i = 0; i < num; i++){
            sum += num2.charAt(i)-'0';
        }

        System.out.println(sum);


    }
}
