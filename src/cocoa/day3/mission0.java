package cocoa.day3;

import java.util.*;

class RandomPick {
    static List<String> members = new ArrayList<>(List.of("검봉", "노리", "땃쥐", "반스", "피오", "호두마루", "Barney", "Bart", "BC", "Dave", "Dike",
            "donggi", "Ella", "Hanse", "Hoo", "Jarry", "Jerry", "Jhin", "Jun", "K", "Konda", "mandoo", "meatsby", "MK",
            "mong", "OS", "Phil", "Sonny", "taksu", "Tany", "Teemo", "Yan", "ZZZ_호눅스"));

    public int ask() {
        int people = 0;

        while (people < 1 || people > 33) {

            System.out.println("몇 명을 뽑을까요?(33명 이내)");

            Scanner sc = new Scanner(System.in);
            people = sc.nextInt();
        }
        return people;
    }

    public static List<String> getNames(int number) {
        Collections.shuffle(members);
        return members.subList(0, number);
    }

    public static void main(String[] args) {
        RandomPick c1 = new RandomPick();
        int num = c1.ask();
        List<String> names = getNames(num);
        for (int i = 0; i < names.size(); i++) {
            System.out.print(names.get(i));
            if (i < names.size() - 1) {
                System.out.print("," + " ");
            }
        }
    }
}

//    }

//    public int[] randomNumber(int c) {
//
//        Random r = new Random();
//        int[] numlist = new int[c];
//
//        for (int i = 0; i < c; i++) {
//            numlist[i] = r.nextInt(members.length);
//
//            for (int j = 0; j < i; j++) {
//
//                while (numlist[i] == numlist[j]) {
//                    numlist[i] = r.nextInt(members.length);
//                    j = 0;
//                }
//            }
//
//        }
//        return numlist;
//    }
////
//    public String[] getMembers(int[] n){
//        String[] namelist = new String[n.length];
//        for(int e;e<namelist.length; e++){
//            namelist[e] = members[e];
//        }
//        return namelist;
//    }
//
//
//}
//
//public class mission0 {
//    public static void main(String[] args) {
//
//        RandomPick c = new RandomPick();
//        int count = c.ask();
//
//        int[] names = c.randomNumber(count);
//    }
//}



