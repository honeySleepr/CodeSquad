package cocoa.week3.Clock;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class Clock {
    static Calendar time = Calendar.getInstance();

    static public int[] CurrentTime() {
        int hour = time.get(Calendar.HOUR_OF_DAY);
        int min = time.get(Calendar.MINUTE);

        if (hour > 12) {
            hour = time.get(Calendar.HOUR_OF_DAY) - 12;
        }

        int[] currentTime = new int[]{hour, min};
        System.out.println(hour + ":" + min); // 시간 출력 맞는지 확인용
        return currentTime;
    }
}
