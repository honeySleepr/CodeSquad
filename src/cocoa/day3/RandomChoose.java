package cocoa.day3;

import java.util.Random;
import java.util.Scanner;

class Member {
    String[] members = {"Barney", "BC", "Dave", "Dike", "Jhin", "Jun", "meatsby", "mong", "Phil", "호두마루"};
    int people;

    public int inputnumber() {
        Scanner sc = new Scanner(System.in);
        int people;
        System.out.println("몇 명인가요?");
        people = sc.nextInt();

        sc.close();
        return people;
    }

    public int[] getRandomNumber(int people2) {
        this.people = people2;
        Random r = new Random();
        int a[] = new int[people2];

        for (int i = 0; i < people; i++) {
            a[i] = r.nextInt(members.length - 1);
            for (int j = 0; j < i; j++) {
                if (a[i] == a[j]) {
                    i--;
                }
            }
        }
        return a;
    }
}

public class RandomChoose {
    public static void main(String[] args) {
        Member member = new Member();
        int b = member.inputnumber();
        int c[];
        c = member.getRandomNumber(b);
        for (int i = 0; i < member.people; i++) {
            System.out.println(member.members[i]);
        }
    }
}