package cocoa.week3.Clock;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class Table {
    static String[][] table = new String[6][6];

    static public void CreateTable() {
        try {
            try {
                File f = new File("HangulClock.csv");

                Scanner s = new Scanner(f);
                while (s.hasNext()) {
                    for (int i = 0; i < 6; i++) {
                        for (int j = 0; j < 6; j++) {
                            table[i][j] = s.next();
                        }
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("파일을 찾을 수 없습니다");
            }
        } catch (NoSuchElementException e) {
            System.out.println("파일 내용이 비어있습니다");
        }
    }

    static public void printTable() {
        for (String[] e : table) {
            System.out.println(Arrays.toString(e));
        }
    }

    public static void change(int[] currentTime) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        int hour = currentTime[0];
        int min = currentTime[1];

        switch (hour) {
            case 1:
            case 2:
            case 3:
            case 4:
                sb1.append("(");
                sb1.append(table[0][hour % 6-1]);
                sb1.append(")");
                table[0][hour % 6-1] = sb1.toString();
                break;
            case 5:
                sb1.append("(");
                sb1.append(table[0][hour % 6-1]);
                sb1.append(")");
                table[0][hour % 6-1] = sb1.toString();

                sb2.append("(");
                sb2.append(table[0][hour % 6]);
                sb2.append(")");
                table[0][hour % 6] = sb2.toString();
                break;
            case 6:
                sb1.append("(");
                sb1.append(table[1][0]);
                sb1.append(")");
                table[1][0] = sb1.toString();

                sb2.append("(");
                sb2.append(table[1][1]);
                sb2.append(")");
                table[1][1] = sb2.toString();
                break;
            case 7:
                sb1.append("(");
                sb1.append(table[1][2]);
                sb1.append(")");
                table[1][2] = sb1.toString();

                sb2.append("(");
                sb2.append(table[1][3]);
                sb2.append(")");
                table[1][3] = sb2.toString();
                break;
            case 8:
                sb1.append("(");
                sb1.append(table[1][4]);
                sb1.append(")");
                table[1][4] = sb1.toString();

                sb2.append("(");
                sb2.append(table[1][5]);
                sb2.append(")");
                table[1][5] = sb2.toString();
                break;
            case 9:
                sb1.append("(");
                sb1.append(table[2][0]);
                sb1.append(")");
                table[2][0] = sb1.toString();

                sb2.append("(");
                sb2.append(table[2][1]);
                sb2.append(")");
                table[2][1] = sb2.toString();
                break;
            case 10:
                sb1.append("(");
                sb1.append(table[2][2]);
                sb1.append(")");
                table[2][2] = sb1.toString();
                break;
            case 11:
                sb1.append("(");
                sb1.append(table[2][2]);
                sb1.append(")");
                table[2][2] = sb1.toString();

                sb2.append("(");
                sb2.append(table[2][3]);
                sb2.append(")");
                table[2][3] = sb2.toString();
                break;
            case 12:
                sb1.append("(");
                sb1.append(table[2][2]);
                sb1.append(")");
                table[2][2] = sb1.toString();

                sb2.append("(");
                sb2.append(table[2][4]);
                sb2.append(")");
                table[2][4] = sb2.toString();
                break;
            default:
                System.out.println("Error");
        }

    }
}
