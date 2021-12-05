package Programmers.level1;

import java.util.ArrayList;
import java.util.Collections;

/*나누어 떨어지는 숫자 배열*/
public class DividableArr {
    public static void main(String[] args) {
        Solution1 s = new Solution1();
        s.solution(new int[]{2, 36, 1, 3}, 1);
    }
}

class Solution1 {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] answer;
        for (int i : arr) {
            if (i % divisor == 0) {
                list.add(i);
            }
        }
        Collections.sort(list);
        if (list.size() == 0) {
            answer = new int[]{-1};
        } else {
            answer = new int[list.size()];
        }

        for (int j = 0; j < list.size(); j++) {
            answer[j] = list.get(j);
        }

        return answer;
    }
}
