package cocoa.week3.Clock;

class ClockMain implements Runnable {

    public void run() {
        StartApp startApp = new StartApp();
        try {
            while (true) {
                startApp.currentTime();
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            System.out.println("-종료-");
        }
    }
    public static void main(String[] args) {
        Run r = new Run();
        String option = r.Start();
        r.loop(option);
    }


}