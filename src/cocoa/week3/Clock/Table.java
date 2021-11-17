package cocoa.week3.Clock;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class Table {
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String CYAN_BRIGHT = "\033[0;96m";   // CYAN
    public static final String WHITE = "\033[0;37m";   // WHITE
    public static final String	INVISIBLE_TEXT		= "\u001B[8m";
    public static final String	YELLOW				= "\u001B[33m";

    int hour;
    int min;
    int dayNight;
    String[][] table = {
            {"한", "두", "세", "네", "다", "섯"},
            {"여", "섯", "일", "곱", "여", "덟"},
            {"아", "홉", "열", "한", "두", "시"},
            {"자", "이", "삼", "사", "오", "십"},
            {"정", "일", "이", "삼", "사", "육"},
            {"오", "오", "칠", "팔", "구", "분"}
    };
//             new String[6][6];

    public Table(int hour, int min, int dayNight) {
        this.hour = hour;
        this.min = min;
        this.dayNight = dayNight;
    }

    public void createTable() {
//        try {
//            File file = new File("HangulClock.csv");
//            Scanner s = new Scanner(file);
//            while (s.hasNext()) {
//                for (int i = 0; i < 6; i++) {
//                    for (int j = 0; j < 6; j++) {
//                        table[i][j] = s.next();
//                    }
//                }
//            }
//        } catch (NoSuchElementException | FileNotFoundException e) {
//            e.printStackTrace();
//        }
        changeHour();
        changeMin();
        System.out.printf("\n %02d : %02d \n", hour, min);
        printTable();
    }

    public void printTable() {
        try {
            for (String[] e : table) {
                for (String f : e) {
                    if (f.endsWith("<")) {
                        f = f.substring(0, f.length() - 1);
                        System.out.printf(YELLOW + "%3s" + ANSI_RESET, f);
                    } else {
                        System.out.printf(ANSI_BLACK + "%3s" + ANSI_RESET, f);
                    }
                }
                System.out.println();
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    void wrap(int a, int b) {
        String sb1 = table[a][b] + "<";
        table[a][b] = sb1;
    }

    void changeHour() {
        if (!(hour == 12 && min == 0)) {
            wrap(2, 5);
        }
        switch (hour) {
            case 1:
                wrap(0, 0);
                break;
            case 2:
                wrap(0, 1);
                break;
            case 3:
                wrap(0, 2);
                break;
            case 4:
                wrap(0, 3);
                break;
            case 5:
                wrap(0, 4);
                wrap(0, 5);
                break;
            case 6:
                wrap(1, 0);
                wrap(1, 1);
                break;
            case 7:
                wrap(1, 2);
                wrap(1, 3);
                break;
            case 8:
                wrap(1, 4);
                wrap(1, 5);
                break;
            case 9:
                wrap(2, 0);
                wrap(2, 1);
                break;
            case 10:
                wrap(2, 2);
                break;
            case 11:
                wrap(2, 2);
                wrap(2, 3);
                break;
            case 12:
                if (min == 0 && dayNight == 0) {
                    wrap(3, 0);
                    wrap(4, 0);
                } else if (min == 0 && dayNight == 1) {
                    wrap(4, 0);
                    wrap(5, 0);
                } else {
                    wrap(2, 2);
                    wrap(2, 4);
                }
                break;
            default:
                System.out.println("Hour Error");
        }
    }

    void changeMin() {

        if (!(min == 0)) {
            wrap(5, 5);
        }
        switch (min % 10) {
            case 0:
                break;
            case 1:
                wrap(4, 1);
                break;
            case 2:
                wrap(4, 2);
                break;
            case 3:
                wrap(4, 3);
                break;
            case 4:
                wrap(4, 4);
                break;
            case 5:
                wrap(5, 1);
                break;
            case 6:
                wrap(4, 5);
                break;
            case 7:
                wrap(5, 2);
                break;
            case 8:
                wrap(5, 3);
                break;
            case 9:
                wrap(5, 4);
                break;
            default:
                System.out.println("Min Error");
        }
        switch (min / 10) {
            case 0:
                break;
            case 1:
                wrap(3, 5);
                break;
            case 2:
                wrap(3, 5);
                wrap(3, 1);
                break;
            case 3:
                wrap(3, 5);
                wrap(3, 2);
                break;
            case 4:
                wrap(3, 5);
                wrap(3, 3);
                break;
            case 5:
                wrap(3, 5);
                wrap(3, 4);
                break;
            default:
                System.out.println("Min Error");
        }
    }
}
