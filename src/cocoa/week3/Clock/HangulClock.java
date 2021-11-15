package cocoa.week3.Clock;

import java.util.Arrays;
import java.util.Calendar;

class HangulClock {
    public static void main(String[] args) {
        Table.CreateTable();
        Table.printTable();
        Clock clock = new Clock();
        clock.CurrentTime();
    }
}
