package Programmers.level1;

public class AddMissingNumber {
    public static void main(String[] args) {
        Solution4 s = new Solution4();
        s.solution(new int[]{1, 2, 3, 4, 6, 7, 8, 0});
    }
}

class Solution4 {
    public int solution(int[] numbers) {

        int answer = 0;
        for (int i = 1; i < 10; i++) {
            boolean included = false;
            for (int index = 0; index < numbers.length; index++) {
                if (numbers[index] == i) {
                    included = true;
                    break;
                }

            }
            if (!included) {
                answer += i;
            }
        }
        System.out.println(answer);
        return answer;
    }
}