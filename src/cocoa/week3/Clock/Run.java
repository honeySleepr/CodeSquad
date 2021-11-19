package cocoa.week3.Clock;

import java.util.Scanner;

public class Run {
    boolean quit;
    boolean clockOn;

    public String Start() {
        System.out.print("Enter command : ");
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        while (!(command.equals("cal") || command.equals("clock"))) {
            System.out.print("Enter command [cal/clock] : ");
            command = sc.nextLine();
        }
        return command;
    }

    public void loop(String option) {
        Runnable runnable = new ClockMain();
        Thread thread = new Thread(runnable);
        StartApp startApp = new StartApp();

        if (option.equals("clock")) {
            thread.start();
            clockOn = true;
        }
        if (option.equals("cal")) {
            startApp.currentDate();
            System.out.print("Enter command : ");
        }
        while (!quit) {
            String newOption = changeOption();
            switch (newOption) {
                case "s":
                    thread.interrupt();
                    clockOn = false;
                    break;
                case "q":
                    thread.interrupt();
                    try{
                        Thread.sleep(100);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println("-프로그램 종료-");
                    break;
                case "clock":
                    if (clockOn) {
                        System.out.println("-clock 이미 실행중-");
                    }
                    if (!clockOn) {
                        thread = new Thread(runnable);
                        thread.start();
                    }
                    break;
                case "cal":
                    thread.interrupt();
                   try{
                       Thread.sleep(100);
                   }catch(InterruptedException e){
                       e.printStackTrace();
                   }
                    clockOn = false;
                    startApp.currentDate();
                    break;
                default:
                    System.out.println("Commands: [cal/clock/q/s]");
                    break;
            }
            if (newOption.equals("clock")) {
                clockOn = true;
            }
        }
    }

    public String changeOption() {
        Scanner sc1 = new Scanner(System.in);
        String newOption = sc1.nextLine();
        if (newOption.equals("q")) {
            quit = true;

        }
        return newOption;
    }


}
