package cocoa.masters;

import java.util.ArrayList;
import java.util.Scanner;

public class Control {
    String[][] encrypt;

    Control(String[][] encrypt) {
        this.encrypt = encrypt;
        startConsole();
    }

    private void startConsole() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Character> commandArray = new ArrayList<>();
        while (true) {
            System.out.print("SOKOBAN> ");
            String command = sc.nextLine();
            for (int i = 0; i < command.length(); i++) {
                commandArray.add(command.charAt(i));
            }
            boolean valid = checkKey(commandArray);
            if (commandArray.contains('q')) {
                System.out.print("Bye~");
                sc.close();
                return;

            }
            if (valid) {
                inputCommand(commandArray);
                commandArray.clear();
            }
        }
    }


    private void inputCommand(ArrayList<Character> commandArray) {
        for (Character c : commandArray) {
            switch (c) {
                case 'w':
                    System.out.print("W: ");
                    moveUp();
                    break;
                case 's':
                    System.out.print("S: ");
                    moveDown();
                    break;
                case 'a':
                    System.out.print("A: ");
                    moveLeft();
                    break;
                case 'd':
                    System.out.print("D: ");
                    moveRight();
                    break;
                default:
                    break;
            }
        }
    }

    private void moveUp() {
        DisplayContent display = new DisplayContent();
        int[] current = display.findPlayer(encrypt);

        int x1 = current[0];
        int y1 = current[1];
        int x2 = current[0] - 1;
        int y2 = current[1];

        makeMove(x1, y1, x2, y2, encrypt);
        new CreateGame(encrypt);
    }

    private void moveDown() {
        DisplayContent display = new DisplayContent();
        int[] current = display.findPlayer(encrypt);

        int x1 = current[0];
        int y1 = current[1];
        int x2 = current[0] + 1;
        int y2 = current[1];

        makeMove(x1, y1, x2, y2, encrypt);
        new CreateGame(encrypt);
    }

    private void moveLeft() {
        DisplayContent display = new DisplayContent();
        int[] current = display.findPlayer(encrypt);

        int x1 = current[0];
        int y1 = current[1];
        int x2 = current[0];
        int y2 = current[1] - 1;

        makeMove(x1, y1, x2, y2, encrypt);
        new CreateGame(encrypt);
    }

    private void moveRight() {
        DisplayContent display = new DisplayContent();
        int[] current = display.findPlayer(encrypt);

        int x1 = current[0];
        int y1 = current[1];
        int x2 = current[0];
        int y2 = current[1] + 1;
        makeMove(x1, y1, x2, y2, encrypt);
        new CreateGame(encrypt); //print new map
    }

    private void makeMove(int x1, int y1, int x2, int y2, String[][] encrypt) {
        if (encrypt[x2][y2].equals("")) {
            System.out.println("이동합니다");
            encrypt[x2][y2] = encrypt[x1][y1];
            encrypt[x1][y1] = "";
        } else {
            System.out.println("해당 명령을 수행할 수 없습니다");
        }
    }

    private boolean checkKey(ArrayList<Character> commandArray) {
        for (Character c : commandArray) {
            if (!(c.equals('a') || c.equals('w') || c.equals('s') || c.equals('d') || c.equals('q'))) {
                System.out.println("다음 범위 내에서 입력 : \n [w : 위] [s : 아래] [a : 좌] [d : 우] [q : 종료] \n");
                commandArray.clear();
                return false;
            }
        }
        return true;
    }
}
