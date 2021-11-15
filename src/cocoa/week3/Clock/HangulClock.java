package cocoa.week3.Clock;

class HangulClock extends Thread {
    public void run() {
        try {
            Clock clock = new Clock();
            clock.currentTime();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    public static void main(String[] args) {
        while (true) {

            try {
                Thread t = new HangulClock();
                t.start();
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}