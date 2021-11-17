package cocoa.week3.Clock;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoField;

import static java.time.temporal.ChronoField.*;

class StartApp {
    Table timeTable;
    Table calendar;

    void currentTime() {
        LocalTime local = LocalTime.now();
        int hour, min, dayNight;
        hour = local.get(CLOCK_HOUR_OF_AMPM);
        min = local.get(MINUTE_OF_HOUR);
        dayNight = local.get(AMPM_OF_DAY);  // AM:0, PM:1

        timeTable = new Table(hour, min, dayNight);
        timeTable.createTable();
    }

    void currentDate() {
        LocalDate today = LocalDate.now();
        int firstDayNum = today.withDayOfMonth(1).get(DAY_OF_WEEK);
        int lastDay = today.getMonth().maxLength();
        int date = today.get(DAY_OF_MONTH);

//        int year, month, date, dayOfWeek;
//        year = today.get(YEAR);
//        month = today.get(MONTH_OF_YEAR);

//        dayOfWeek = today.get(DAY_OF_WEEK);
//        System.out.println(year + " " + month + " " + date + " " + dayOfWeek);


        calendar = new Table(today,firstDayNum,lastDay,date);
        calendar.createCalendar();
    }

    void inputCommand() {
    }
}

