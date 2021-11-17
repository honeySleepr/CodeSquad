package cocoa.week3.Clock;

import java.util.Scanner;

class ClockMain implements Runnable {
    static boolean quit;
    static boolean clock;

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

    public static void main(String[] args) {
        String option = Start();
        Runnable runnable = new ClockMain();
        Thread thread = new Thread(runnable);

        if (option.equals("clock")) {
            thread.start();
        }
        if (option.equals("cal")) {
            System.out.println("CALENDER NOT READY YET");
            System.out.print("Enter command : ");
        }
        while (!quit) {
            String newOption = changeOption(option);
            if(option.equals("clock") || newOption.equals("clock")){
                clock = true;
            }

            if (newOption.equals("q")) {
                thread.interrupt();
            }
            if (newOption.equals("clock")) {
                thread.interrupt();
                thread.start();
            }
            if (newOption.equals("cal")) {
                System.out.println("CALENDER NOT READY YET");
            }
        }
    }

    private static String changeOption(String option) {
        Scanner sc = new Scanner(System.in);
        String newOption = sc.nextLine();
        while(option.equals("clock") && newOption.equals("clock")) {
            System.out.println("-clock 이미 실행중-");
            newOption = sc.nextLine();
        }
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
            System.out.print("Enter command : ");
            command = sc.nextLine();
        }
        return command;
    }
}