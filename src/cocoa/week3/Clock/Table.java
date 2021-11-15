package cocoa.week3.Clock;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class Table {
    static List<String[]> table = new ArrayList<>();

    static public List<String[]> Table() {
        try {
            try {
                File f = new File("HangulClock.csv");

                Scanner s = new Scanner(f);
                while (s.hasNext()) {
                    String[] letter = new String[6];
                    for (int i = 0; i < 6; i++) {

                        letter[i] = s.next();

                        if (i == 5) {
                            table.add(letter);
                        }
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("파일을 찾을 수 없습니다");
            }
        } catch (NoSuchElementException e) {
            System.out.println("파일 내용이 비어있습니다");
        }
        return table;
    }

    static public void printTable(){
        for (String[] e : table) {
            System.out.println(Arrays.toString(e));
        }
    }

}
