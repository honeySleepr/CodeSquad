package BaekJoon;
//입력된 단어에서 가장 많이 사용된 알파벳을 출력. 단, 여기에 해당되는 알파벳이 두 개 이상인 경우 "?" 출력
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BJ1157 {
    public static void main(String[] args) {
        HashSet<Character> letter = new HashSet<>();
        String input = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            input = br.readLine().toUpperCase();
            for (Character c : input.toCharArray()) {
                letter.add(c);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int startIndex = 0;
        int count = 0;
        int maxCount = 0;
        boolean onlyOne = true;
        Character finalChar = '0';
        for (Character c : letter) {
            while (input.indexOf(c, startIndex) != -1) {
                count++;
                startIndex = input.indexOf(c, startIndex) + 1;
            }
            if (maxCount < count) {
                onlyOne = true;
                maxCount = count;
                finalChar = c;

            } else if (maxCount == count) {
                onlyOne = false;
            }
            count = 0;
            startIndex = 0;
        }
        if (!onlyOne) {
            System.out.println("?");
        }else{
            System.out.println(finalChar);
        }
    }
}
