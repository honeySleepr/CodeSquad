package cocoa.week3.Clock;

import java.time.LocalDate;

class Table {
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String YELLOW = "\u001B[33m";
    int hour, min, dayNight;
    int firstDayOfMonth, lastDayOfMonth, date;
    LocalDate today;
    String[][] table = {
            {"한", "두", "세", "네", "다", "섯"},
            {"여", "섯", "일", "곱", "여", "덟"},
            {"아", "홉", "열", "한", "두", "시"},
            {"자", "이", "삼", "사", "오", "십"},
            {"정", "일", "이", "삼", "사", "육"},
            {"오", "오", "칠", "팔", "구", "분"}
    };
    Boolean[][] checkTable = {
            {false, false, false, false, false, false},
            {false, false, false, false, false, false},
            {false, false, false, false, false, false},
            {false, false, false, false, false, false},
            {false, false, false, false, false, false},
            {false, false, false, false, false, false}
    };

    public Table(int hour, int min, int dayNight) {
        this.hour = hour;
        this.min = min;
        this.dayNight = dayNight;
    }

    public Table(LocalDate today, int firstDayOfMonth, int lastDayOfMonth, int date) {
        this.today = today;
        this.firstDayOfMonth = firstDayOfMonth;
        this.lastDayOfMonth = lastDayOfMonth;
        this.date = date;
    }
    public Table(LocalDate today, int firstDayOfMonth, int lastDayOfMonth) {
        this.today = today;
        this.firstDayOfMonth = firstDayOfMonth;
        this.lastDayOfMonth = lastDayOfMonth;
    }

    public void createTable() {
        changeHour();
        changeMin();
        printTable();
//        System.out.printf("\n %02d : %02d \n", hour, min);
    }

    public void printTable() {
        try {
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    if (checkTable[i][j]) {
                        System.out.printf(YELLOW + "%3s" + ANSI_RESET, table[i][j]);
                    } else {
                        System.out.printf(ANSI_BLACK + "%3s" + ANSI_RESET, table[i][j]);
                    }
                }
                System.out.println();
            }
            System.out.println();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    void mark(int a, int b) {
        checkTable[a][b] = true;
    }

    void changeHour() {
        if (!(hour == 12 && min == 0)) {
            mark(2, 5);
        }
        switch (hour) {
            case 1:
                mark(0, 0);
                break;
            case 2:
                mark(0, 1);
                break;
            case 3:
                mark(0, 2);
                break;
            case 4:
                mark(0, 3);
                break;
            case 5:
                mark(0, 4);
                mark(0, 5);
                break;
            case 6:
                mark(1, 0);
                mark(1, 1);
                break;
            case 7:
                mark(1, 2);
                mark(1, 3);
                break;
            case 8:
                mark(1, 4);
                mark(1, 5);
                break;
            case 9:
                mark(2, 0);
                mark(2, 1);
                break;
            case 10:
                mark(2, 2);
                break;
            case 11:
                mark(2, 2);
                mark(2, 3);
                break;
            case 12:
                if (min == 0 && dayNight == 0) {
                    mark(3, 0);
                    mark(4, 0);
                } else if (min == 0 && dayNight == 1) {
                    mark(4, 0);
                    mark(5, 0);
                } else {
                    mark(2, 2);
                    mark(2, 4);
                }
                break;
            default:
                System.out.println("Hour Error");
        }
    }

    void changeMin() {

        if (!(min == 0)) {
            mark(5, 5);
        }
        switch (min % 10) {
            case 0:
                break;
            case 1:
                mark(4, 1);
                break;
            case 2:
                mark(4, 2);
                break;
            case 3:
                mark(4, 3);
                break;
            case 4:
                mark(4, 4);
                break;
            case 5:
                mark(5, 1);
                break;
            case 6:
                mark(4, 5);
                break;
            case 7:
                mark(5, 2);
                break;
            case 8:
                mark(5, 3);
                break;
            case 9:
                mark(5, 4);
                break;
            default:
                System.out.println("Min Error");
        }
        switch (min / 10) {
            case 0:
                break;
            case 1:
                mark(3, 5);
                break;
            case 2:
                mark(3, 5);
                mark(3, 1);
                break;
            case 3:
                mark(3, 5);
                mark(3, 2);
                break;
            case 4:
                mark(3, 5);
                mark(3, 3);
                break;
            case 5:
                mark(3, 5);
                mark(3, 4);
                break;
            default:
                System.out.println("Min Error");
        }
    }

    public void printCalendar() {
        System.out.printf(ANSI_BLACK+"%-4s%-4s%-4s %-4s%-4s%-4s%-4s"+ANSI_RESET, "일", "월", "화", "수", "목", "금", "토");
        System.out.println();
        for (int i = 0; i < firstDayOfMonth%7; i++) {
            System.out.printf("     ");
        }
        for (int i = 1; i <= lastDayOfMonth; i++) {
            if (i == date) {
                System.out.printf(YELLOW + "%-5d" + ANSI_RESET, i);
            } else {
                System.out.printf("%-5d", i);
            }
            if ((firstDayOfMonth + i) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.print("\n\n");
    }
}
