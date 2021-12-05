package Programmers.level1;

import java.util.Arrays;
import java.util.Collections;

public class ArrayKthNumber {
    public static void main(String[] args) {
Solution3 s = new Solution3();
        int[] array = new int[]{1, 5, 2, 6, 3, 7, 4};
        int[][] commands = new int[][]{{2,5,3},{4,4,1},{1,7,3}};
        s.solution(array, commands);
    }
}

class Solution3 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
                int[] temporary =
                        Arrays.copyOfRange
                                (array,commands[i][0]-1,commands[i][1]);
                Arrays.sort(temporary);

            answer[i] = temporary[commands[i][2]-1];

            }

        return answer;
    }
}