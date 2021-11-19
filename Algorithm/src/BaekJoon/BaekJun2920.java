package BaekJun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
// 다장조는 c d e f g a b C, 총 8개 음으로 이루어져있다. 이 문제에서 8개 음은 다음과 같이 숫자로 바꾸어 표현한다. c는 1로, d는 2로, ..., C를 8로 바꾼다.
//1부터 8까지 차례대로 연주한다면 ascending, 8부터 1까지 차례대로 연주한다면 descending, 둘 다 아니라면 mixed 이다.
//연주한 순서가 주어졌을 때, 이것이 ascending인지, descending인지, 아니면 mixed인지 판별하는 프로그램을 작성하시오.
public class BaekJun2920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        // Integer 8개를 입력 받는다
        for (int i = 0; i < 8; i++) {
            arr.add(sc.nextInt());
        }
        //오름차순 List 생성
        ArrayList<Integer> arrAscend = new ArrayList<>(arr);
        Collections.sort(arrAscend);
        //내림차순 List 생성
        ArrayList<Integer> arrDescend = new ArrayList<>(arr);
        arrDescend.sort(Collections.reverseOrder());
        //비교(순서까지 일치해야 true)
        if (arr.equals(arrAscend)) {
            System.out.println("ascending");
        }else if(arr.equals(arrDescend)) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }
    }
}

