package cocoa.day6;

import java.util.Scanner;

 class Player {
    public String RegisterUser() {

        System.out.println("ID를 입력하세요");
        Scanner sc = new Scanner(System.in);
        String Id = sc.nextLine();

        System.out.println("비밀번호를 입력하세요");
        String Pw = sc.nextLine();
        System.out.println("비밀번호를 다시 한번 입력하세요");
        String Pw2 = sc.nextLine();
        while (!Pw.equals(Pw2)) {
            System.out.println("비밀번호가 다릅니다. 다시 한번 입력하세요");
            System.out.println("Pw :" + Pw + "/ Pw2:" + Pw2);

            Pw2 = sc.nextLine();
        }
        System.out.println("ID:" + Id);
        System.out.println("PW:" + Pw);
//ShowOption start = new ShowOption();
//start.StartMenu();
        return Id;

    }

}

public class OddEven {
    public static void main(String[] args) {

    }
}

