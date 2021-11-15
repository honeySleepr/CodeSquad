package cocoa.week3.Clock;

import java.util.Arrays;
import java.util.Calendar;

class HangulClock {
    public static void main(String[] args) {
        Table.CreateTable();
        Clock clock = new Clock();
        Table.change(clock.CurrentTime());

        Table.printTable();

    }
}
