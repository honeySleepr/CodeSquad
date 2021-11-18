package cocoa.week3.Clock;

import java.util.Scanner;

class ClockMain implements Runnable {
    static boolean quit;
    static boolean clockOn;

    public static void main(String[] args) {
        String option = Start();
        loop(option);
    }

    public void run() {
        StartApp startApp = new StartApp();
        try {
            while (!quit) {
                startApp.currentTime();
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            System.out.println("-종료-");
        }
    }

    private static void loop(String option) {
        Runnable runnable = new ClockMain();
        Thread thread = new Thread(runnable);

        if (option.equals("clock")) {
            thread.start();
        }
        if (option.equals("cal")) {
            System.out.println("CALENDAR NOT READY");
            System.out.print("Enter command : ");
        }
        while (!quit) {
            String newOption = changeOption(option);
            switch (newOption) {
                case "q":
                    thread.interrupt();
                    break;

                case "clock":
                    if (clockOn) {
                        System.out.println("-clock 이미 실행중-");
                    } else {
                        thread.start();
                    }
                    break;

                case "cal":
                    System.out.println("CALENDAR NOT READY");
                    break;

                default:
                    if (!clockOn) {
                        System.out.println("Commands: [cal/clock/q]");
                    }
                    break;
            }
            if (option.equals("clock") || newOption.equals("clock")) {
                clockOn = true;
            }
        }
    }

    private static String changeOption(String option) {
        Scanner sc = new Scanner(System.in);
        String newOption = sc.nextLine();
        if (newOption.equals("q")) {
            quit = true;
        }
        return newOption;
    }

    static public String Start() {
        System.out.print("Enter command : ");
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        while (!(command.equals("cal") || command.equals("clock"))) {
            System.out.print("Enter command [cal/clock] : ");
            command = sc.nextLine();
        }
        return command;
    }
}