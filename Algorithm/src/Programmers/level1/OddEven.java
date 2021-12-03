package Programmers.level1;

public class OddEven {
    public static void main(String[] args) {
Solution2 s = new Solution2();
        s.solution2(8);
    }
}

class Solution2{
    public String solution2(int num){
        String answer = "";
        if(num%2 ==0){
            answer = "Even";
        } else{
            answer = "Odd";
        }
        System.out.println(answer);
        return answer;
    }
}