package cocoa.day3;

import java.util.Scanner;
import java.util.Random;

class RandomPick2 {
    public static String[] members = {"검봉", "노리", "땃쥐", "반스", "피오", "호두마루", "Barney", "Bart", "BC", "Dave", "Dike",
            "donggi", "Ella", "Hanse", "Hoo", "Jarry", "Jerry", "Jhin", "Jun", "K", "Konda", "mandoo", "meatsby", "MK",
            "mong", "OS", "Phil", "Sonny", "taksu", "Tany", "Teemo", "Yan", "ZZZ_호눅스"};

    public int ask() {
        int people = 0;
        while (people < 1 || people > 33) {
            System.out.println("몇 명을 뽑을까요?(33명 이내)");
            Scanner sc = new Scanner(System.in);
            people = sc.nextInt();
        }
        return people;
    }

    public int[] shuffle(int k) {
        Random r = new Random();
        int[] num = new int[k];
        for (int i = 0; i < k; i++) {
            num[i] = r.nextInt(members.length);
            for (int j = 0; j < i; j++) {
                while (num[i] == num[j]) {
                    num[i] = r.nextInt(members.length);
                    j = 0;
                }
            }
        }
        return num;
    }

    public void print(int[] n) {
        for (int i = 0; i < n.length; i++) {
            System.out.print(members[n[i]]);
            if (i < n.length - 1) {
                System.out.print("," + " ");
            }
        }
    }
}

public class mission0Ver2 {
    public static void main(String[] args) {
        RandomPick2 r = new RandomPick2();
        int num = r.ask();
        int[] index = new int[num];
        index = r.shuffle(num);
        r.print(index);

    }
}


