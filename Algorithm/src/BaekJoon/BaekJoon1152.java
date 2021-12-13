package BaekJoon;

import java.util.List;
import java.util.Scanner;

public class BaekJoon1152 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list;
        list = List.of(sc.nextLine().split(" "));
        if (list.get((0)).equals("")) {
            System.out.println(list.size() - 1);
        } else {
            System.out.println(list.size());
        }
    }
}
