package cocoa.week3.Clock;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import static java.time.temporal.ChronoField.*;

class StartApp {
    Table table;

    void currentTime() {
        LocalTime local = LocalTime.now();
        int hour, min, dayNight;
        hour = local.get(CLOCK_HOUR_OF_AMPM);
        min = local.get(MINUTE_OF_HOUR);
        dayNight = local.get(AMPM_OF_DAY);  // AM:0, PM:1

        table = new Table(hour, min, dayNight);
        table.createTable();
    }

    void currentDate() {
        System.out.println("This month : 1 / Other Month :2 ");
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        while (!(command.equals("1") || command.equals("2"))) {
            System.out.println("This month : 1 / Other Month :2 ");
            command = sc.nextLine();
        }
        if (command.equals("1")) {
            LocalDate today = LocalDate.now();

            int firstDayOfMonth = today.withDayOfMonth(1).get(DAY_OF_WEEK);
            int lastDayOfMonth = today.lengthOfMonth();
            int date = today.getDayOfMonth();
            System.out.println("          "+today.getYear()+"년 "+today.getMonthValue()+"월");
            table = new Table(today, firstDayOfMonth, lastDayOfMonth, date);
            table.printCalendar();
        }
        if (command.equals("2")) {
            otherDate();
        }
    }

    public void otherDate() {
        System.out.println("년도 입력");
        Scanner sc = new Scanner(System.in);
        String st1 = sc.nextLine();
        while (Integer.parseInt(st1) > 3000 || Integer.parseInt(st1) < 1) {
            System.out.println("년도 입력 (예:2021)");
            st1 = sc.nextLine();
        }
        System.out.println("월 입력");
        String st2 = sc.nextLine();
        while (Integer.parseInt(st2) < 1 || Integer.parseInt(st2) > 12) {
            System.out.println("월 입력 (1~12)");
            st2 = sc.nextLine();
        }
        int year = Integer.parseInt(st1);
        int month = Integer.parseInt(st2);
        System.out.println("          "+year+"년 "+month+"월");

        LocalDate today = LocalDate.of(year, month,1);
        int firstDayOfMonth = today.withDayOfMonth(1).get(DAY_OF_WEEK);
        int lastDayOfMonth = today.lengthOfMonth();

        table = new Table(today, firstDayOfMonth, lastDayOfMonth);
        table.printCalendar();
    }
}

