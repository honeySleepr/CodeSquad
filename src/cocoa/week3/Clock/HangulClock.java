package cocoa.week3.Clock;

class HangulClock implements Runnable {
    public void run() {
        Clock clock = new Clock();
        clock.currentTime();
    }

    public static void main(String[] args) {
        try {
            while (true) {
                Thread thread = new Thread(new HangulClock());
                thread.start();
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}