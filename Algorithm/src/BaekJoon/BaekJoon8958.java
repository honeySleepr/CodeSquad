package BaekJun;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaekJoon8958 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int caseNum = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < caseNum; i++) {
            list.add(sc.nextLine().toUpperCase());
        }
        int count = 0;
        int score = 0;
        for (int i = 0; i < caseNum; i++) {
            for (int j = 0; j < list.get(i).length(); j++) {
                if (list.get(i).charAt(j) == 'O') {
                    count++;
                }
                if (list.get(i).charAt(j) == 'X') {
                    count = 0;
                }
                score += count;
            }
            System.out.println(score);
            count = 0;  // 제출할 때 이 부분 빼먹어서 애먹었다..@땃쥐 만세
            score = 0;
        }
    }
}

