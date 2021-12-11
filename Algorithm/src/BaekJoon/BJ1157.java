package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;

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
            System.out.println(letter);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(input);
    }
}
