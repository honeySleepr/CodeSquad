package cocoa.masters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Control3 {
    private final String[][] encryptedMap;
    int turnCount;
    boolean quit = false;

    Control3(String[][] tempMap) {
        this.encryptedMap = tempMap;
        this.turnCount = 0;
        startConsole();
    }

    private void startConsole() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Character> commandArray = new ArrayList<>();
        while (true) {
            System.out.print("SOKOBAN> ");
            String command = sc.nextLine();
            if (command.equals("q")) {
                quit = true;
                return;
            }
            if (command.equals("r")) {
                turnCount = -1;
                return;
            }
            if (command.equals("operation cwal")) {
                turnCount = -2;
                return;
            }
            for (int i = 0; i < command.length(); i++) {
                commandArray.add(command.charAt(i));
            }
            boolean valid = checkKey(commandArray);
            if (valid) {
                inputCommand(commandArray);
                commandArray.clear();
            }
            if (!Arrays.deepToString(encryptedMap).contains("2")) {
                return;
            }
        }
    }

    private void inputCommand(ArrayList<Character> commandArray) {
        for (Character c : commandArray) {
            turnCount++;
            switch (c) {
                case 'w':
                    moveUp();
                    break;
                case 's':
                    moveDown();
                    break;
                case 'a':
                    moveLeft();
                    break;
                case 'd':
                    moveRight();
                    break;
                default:
                    break;
            }
            ConvertMap3.getInstance().displayMap(encryptedMap); //print updated map
        }
    }

    private void moveUp() {
        DisplayContent display = new DisplayContent();
        int[] current = display.findPlayer(encryptedMap);

        int x1 = current[0];
        int y1 = current[1];
        int x2 = current[0] - 1;
        int y2 = current[1];
        makeMove(x1, y1, x2, y2);
    }

    private void moveDown() {
        DisplayContent display = new DisplayContent();
        int[] current = display.findPlayer(encryptedMap);

        int x1 = current[0];
        int y1 = current[1];
        int x2 = current[0] + 1;
        int y2 = current[1];
        makeMove(x1, y1, x2, y2);
    }

    private void moveLeft() {
        DisplayContent display = new DisplayContent();
        int[] current = display.findPlayer(encryptedMap);

        int x1 = current[0];
        int y1 = current[1];
        int x2 = current[0];
        int y2 = current[1] - 1;
        makeMove(x1, y1, x2, y2);
    }

    private void moveRight() {
        DisplayContent display = new DisplayContent();
        int[] current = display.findPlayer(encryptedMap);

        int x1 = current[0];
        int y1 = current[1];
        int x2 = current[0];
        int y2 = current[1] + 1;
        makeMove(x1, y1, x2, y2);
    }

    private void makeMove(int x1, int y1, int x2, int y2) {
        emptySpaceLogic(x1, y1, x2, y2);
        holeLogic(x1, y1, x2, y2);
        ballLogic(x1, y1, x2, y2);
        if (encryptedMap[x2][y2].equals("0")) {
            System.out.println("벽이 있어 움직일 수 없습니다");
        }
    }

    private void pushBall(int x1, int y1, int x2, int y2, String x2y2Value) {
        String d = getDirection(x1, y1, x2, y2);
        if (d.equals("vertical")) {
            pushBallVertical(x1, y1, x2, y2, x2 + (x2 - x1), x2y2Value);
        }
        if (d.equals("horizontal")) {
            pushBallHorizontal(x1, y1, x2, y2, y2 + (y2 - y1), x2y2Value);
        }
    }

    private String getDirection(int x1, int y1, int x2, int y2) {
        String direction = "";
        if ((x2 - x1) == -1 || (x2 - x1) == 1) {
            direction = "vertical";
        }
        if ((y2 - y1) == -1 || (y2 - y1) == 1) {
            direction = "horizontal";
        }

        return direction;
    }

    private void pushBallVertical(int x1, int y1, int x2, int y2, int dX, String x2y2Value) {
        if (encryptedMap[dX][y2].equals(" ")) {
            encryptedMap[dX][y2] = "2";
            encryptedMap[x2][y2] = x2y2Value;
            if (encryptedMap[x1][y1].equals("5")) {
                encryptedMap[x1][y1] = "1";
            } else {
                encryptedMap[x1][y1] = " ";
            }
            return;
        }
        if (encryptedMap[dX][y2].equals("1")) {
            encryptedMap[dX][y2] = "6";
            encryptedMap[x2][y2] = x2y2Value;
            if (encryptedMap[x1][y1].equals("5")) {
                encryptedMap[x1][y1] = "1";
            } else {
                encryptedMap[x1][y1] = " ";
            }
        } else {
            System.out.println("길이 막혀있어 밀 수 없습니다");
        }
    }

    private void pushBallHorizontal(int x1, int y1, int x2, int y2, int dY, String x2y2Value) {
        if (encryptedMap[x2][dY].equals(" ")) {
            encryptedMap[x2][dY] = "2";
            encryptedMap[x2][y2] = x2y2Value;
            if (encryptedMap[x1][y1].equals("5")) {
                encryptedMap[x1][y1] = "1";
            } else {
                encryptedMap[x1][y1] = " ";
            }
            return;
        }
        if (encryptedMap[x2][dY].equals("1")) {
            encryptedMap[x2][dY] = "6";
            encryptedMap[x2][y2] = x2y2Value;
            if (encryptedMap[x1][y1].equals("5")) {
                encryptedMap[x1][y1] = "1";
            } else {
                encryptedMap[x1][y1] = " ";
            }
        } else {
            System.out.println("길이 막혀있어 밀 수 없습니다");
        }
    }

    private boolean checkKey(ArrayList<Character> commandArray) {
        for (Character c : commandArray) {
            if (!(c.equals('a') || c.equals('w') || c.equals('s') || c.equals('d'))) {
                System.out.println("다시 입력 - [w,s,a,d : 상,하,좌,우 (연속 입력 가능)] [q : 종료] [r : 리셋]");
                commandArray.clear();
                return false;
            }
        }
        return true;
    }

    private void emptySpaceLogic(int x1, int y1, int x2, int y2) {
        if (encryptedMap[x2][y2].equals(" ")) {
            encryptedMap[x2][y2] = "3";
            if (encryptedMap[x1][y1].equals("5")) {
                encryptedMap[x1][y1] = "1";
            } else {
                encryptedMap[x1][y1] = " ";
            }
        }
    }

    private void holeLogic(int x1, int y1, int x2, int y2) {
        if (encryptedMap[x2][y2].equals("1")) {
            encryptedMap[x2][y2] = "5";
            if (encryptedMap[x1][y1].equals("5")) {
                encryptedMap[x1][y1] = "1";
            } else {
                encryptedMap[x1][y1] = " ";
            }
        }
    }

    private void ballLogic(int x1, int y1, int x2, int y2) {
        if (encryptedMap[x2][y2].equals("2")) {
            pushBall(x1, y1, x2, y2, "3");
        }
        if (encryptedMap[x2][y2].equals("6")) {
            pushBall(x1, y1, x2, y2, "5");
        }
    }
}

