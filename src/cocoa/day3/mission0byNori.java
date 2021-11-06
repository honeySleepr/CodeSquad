package cocoa.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.shuffle;

class RandomSelect {

    public void run() throws IOException {
        int count = input();

        print(count);
    }

    public static final String[] membersArray = {
            "Barney", "BC", "Bart", "Dave", "David", "Dike", "donggi", "Hanse", "Head", "hoo", "Jarry", "Jerry",
            "Jhin", "Jun", "Konda", "Lacon", "Mandoo", "meatsby", "Mk", "mong", "OS", "Phill",
            "sonny", "tasku", "Tany", "Teemo", "Yan", "young", "검봉", "노리", "땃쥐", "반스", "피오", "호두마루"
    };

    private static void print(int count) {
        List<String> membersList = Arrays.asList(membersArray);

        shuffle(membersList);

        List<String> members = membersList.subList(0, count);

        String list = Arrays.toString(members.toArray())
                .replace("[", "")
                .replace("]", "");

        System.out.println(list);
    }

    public static int input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("몇 명인가요?");
        int count = Integer.parseInt(bufferedReader.readLine());

        return count;
    }
}



public class mission0byNori {
    public static void main(String[] args) throws IOException {
        new RandomSelect().run();
    }
}