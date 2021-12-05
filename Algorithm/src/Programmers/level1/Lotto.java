package Programmers.level1;

import java.util.Arrays;
import java.util.HashSet;

public class Lotto {
    public static void main(String[] args) {
Solution5 s = new Solution5();
        s.solution(new int[]{1,6,10,19,31,45}, new int[]{31, 10, 45, 1, 6, 19});
    }
}

class Solution5 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int count = 0;
        int count0 = 0;
        int[] answer = {0,0};

        for (int i = 0; i < 6; i++) {
            for (int winIndex = 0; winIndex < 6; winIndex++) {
                if(lottos[i] == win_nums[winIndex]){
                    count ++;
                    break;
                }
            }
            if(lottos[i]==0){
                count0 ++;
            }
        }
        answer[0] = -(count0 + count - 7);
        answer[1] = -(count-7);

        answer[0] = answer[0] ==7 ? 6 : answer[0];
        answer[1] = answer[1] ==7 ? 6 : answer[1];

        System.out.println(Arrays.toString(answer));
        return answer;
    }
}
