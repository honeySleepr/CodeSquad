package cocoa.day3;

import java.util.Scanner;

class Indian {
    static String[] yearName = {"시끄러운", "푸른", "적색", "조용한", "웅크린", "백색", "지혜로운", "용감한", "날카로운", "욕심많은"};
    static String[] monthName = {"늑대", "태양", "양", "매", "황소", "불꽃", "나무", "달빛", "말", "돼지", "하늘", "바람"};
    static String[] dayName = {"와(과) 함께 춤을", "의 기상", "은(는) 그림자 속에", "", "", "", "의 환생", "의 죽음", "아래에서", "을(를) 보라", "(이)가 노래하다.", "의 그늘", "의 일격", "에게 쫓기는 남자", "의 행진", "의 왕", "의 유령", "을 죽인자", "은(는) 맨날 잠잔다.", "처럼..", "의 고향", "의 전사", "은(는) 나의 친구", "의 노래", "의 정령", "의 파수꾼", "의 악마", "와(과) 같은 사나이", "의 심판자", "의 혼", "은(는) 말이 없다."};

    public static int[] input() {
        System.out.println("생년월일을 입력해주세요(공백으로 년월일 구분)");
        Scanner sc = new Scanner(System.in);

            int year = sc.nextInt();
            int month = sc.nextInt();
            int day = sc.nextInt();

        int[] date = {year, month, day};
        return date;
    }

    public static int[] calculate(int[] date) {
        date[0] = date[0] % 10;
        date[1] = date[1] - 1;
////        월을 01, 02 식으로 입력하면 문제가 될까?
        date[2] = date[2] - 1;
////       일을 01, 02 식으로 입력하면 문제가 될까?
        return date;
    }

    public static void print(int[] newdate) {
        System.out.print("당신의 이름은 ");
        System.out.print(yearName[newdate[0]] + " " + monthName[newdate[1]] + dayName[newdate[2]]);
        System.out.print("입니다.");

    }
//    public static void repeat() {
//        int[] date = Indian.input();
//        date = Indian.calculate(date);
//        Indian.print(date);
//    }
}


public class mission1 {
    public static void main(String[] args) {
            int[] date = Indian.input();
            date = Indian.calculate(date);
            Indian.print(date);
//            Indian.repeat();


        }
    }

