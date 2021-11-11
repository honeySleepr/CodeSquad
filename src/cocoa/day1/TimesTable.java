package cocoa.day1;
import java.util.Scanner;

public class TimesTable {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("1~9 사이의 숫자 두개 입력");

        int num1 = sc.nextInt();
        while(num1<1 || num1>9){
            System.out.println("1~9 사이의 숫자 입력");
            num1 = sc.nextInt();
        }

        int num2 = sc.nextInt();
    while(num2<1 || num2>9 || num1>=num2){
    System.out.println("1~9 사이의 이전 숫자보다 큰 숫자 입력");
    num2 = sc.nextInt();
}
for(int i = num1 ; i <= num2 ; i++){
    for(int j = 1 ; j < 10 ; j++){
        System.out.print( i + "X" + j +"=" + i*j + " ");

    }
    System.out.println();System.out.println();
}
    }
}

