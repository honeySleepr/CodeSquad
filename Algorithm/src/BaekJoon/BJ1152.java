package BaekJoon;

import java.util.Scanner;
import java.util.List;

public class BJ1152 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> stringList = List.of(sc.nextLine().split(" "));
        int count = stringList.size();
        for (String s : stringList) {
            if(s.equals("")){
                count--;
                break;
            }
        }
        System.out.println(count);
        }
    }
