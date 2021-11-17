package cocoa.week3.Clock;

import java.time.LocalTime;
import java.util.Scanner;

import static java.time.temporal.ChronoField.*;

class StartApp {
    LocalTime local = LocalTime.now();
    Table table;

    void currentTime() {
        int hour, min, dayNight;
        hour = local.get(CLOCK_HOUR_OF_AMPM);
        min = local.get(MINUTE_OF_HOUR);
        dayNight = local.get(AMPM_OF_DAY);  // AM:0, PM:1

        table = new Table(hour, min, dayNight);
        table.createTable();

    }


    void currentDate() {

    }

    void inputCommand() {
    }
}

