package cocoa.week1;

import java.util.Scanner;

public class if2884 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hour = sc.nextInt();
        int min = sc.nextInt();
        int newhour = 0;
        int newmin = 0;

        while (hour < 0 || hour > 23) {
            System.out.println("올바른 hour 입력");
            hour = sc.nextInt();
        } while (min < 0 || min > 59) {
            System.out.println("올바른 min 입력");
            min = sc.nextInt();
        }
        if (min < 45) {
            newmin = min - 45 + 60;
            newhour = hour - 1;
            if(hour==0){
                newhour = newhour + 24;
            }
        }
        if (min >= 45) {
            newmin = min - 45;
            newhour = hour;
        }
System.out.println(newhour+" "+newmin);
    }
//    (0 ≤ H ≤ 23, 0 ≤ M ≤ 59)
//    40 -> 55
//    25 -> 40
//     !! 0 -> 23
}
