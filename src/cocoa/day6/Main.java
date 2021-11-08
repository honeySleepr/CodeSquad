package cocoa.day6;

import com.sun.source.tree.WhileLoopTree;

import java.util.Scanner;

// 0. 사용자 정보 입력
class User {
    public void RegisterUser() {

        System.out.println("ID를 입력하세요");
        Scanner sc = new Scanner(System.in);
        String Id = sc.nextLine();

        System.out.println("비밀번호를 입력하세요");
        String Pw = sc.nextLine();
        System.out.println("비밀번호를 다시 한번 입력하세요");
        String Pw2 = sc.nextLine();
        while (!Pw.equals(Pw2)) {
            System.out.println("비밀번호가 다릅니다. 다시 한번 입력하세요");
            System.out.println("Pw :"+Pw+"/ Pw2:"+Pw2);

            Pw2 = sc.nextLine();
        }
        System.out.println("ID:" + Id);
        System.out.println("PW:" + Pw);

    }

}

//// 1.기능 안내
//class ShowOption {
//    public void    {
//        System.out.println("<< 메뉴 >>");
//        System.out.println("1. 내역 등록");
//        System.out.println("2. 전체 출력");
//        System.out.println("3. 수입 출력");
//        System.out.println("4. 지출 출력");
//        System.out.println("5. 종료");
//        System.out.print("선택 > ");
//
//    }
//
//}
//// 2. 입력 데이터 받기
//// 3. 데이터 삭제/수정
//// 4. 데이터 출력
public class Main {
    public static void main(String[] args) {
        User a = new User();
        a.RegisterUser();
    }
}
//ddddd