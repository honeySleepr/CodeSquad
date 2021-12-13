package BaekJoon;
// 9개의 서로 다른 자연수가 주어질 때, 이들 중 최댓값을 찾고 그 최댓값이 몇 번째 수인지를 구하는 프로그램을 작성하시오.
/*Insertion Sort >= Selection Sort > Bubble Sort)*/ //아 sorting이 필요없는거였네..

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2562 {
    public static void main(String[] args) {
        int[] list = new int[9];
        int index = 0;
        int max = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            for (int i = 0; i < list.length; i++) {
                list[i] = Integer.parseInt(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < list.length; i++) {
            if (list[i] > max) {
                index = i;
                max = list[i];
            }
        }
        System.out.println(max);
        System.out.println(index+1);
    }
}
