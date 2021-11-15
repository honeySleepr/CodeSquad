package cocoa.week3.Clock;

import java.time.LocalTime;
import static java.time.temporal.ChronoField.*;

class Clock {
    static LocalTime local = LocalTime.now();

   public int[] CurrentTime() {
       int hour = local.get(CLOCK_HOUR_OF_AMPM);
       int min = local.get(MINUTE_OF_HOUR);

       int[] currentTime = new int[]{hour, min};
       System.out.println(hour + ":" + min); // 시간 출력 맞는지 확인용

        return currentTime;
    }
}
