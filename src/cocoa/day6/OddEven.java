package cocoa.day6;

import java.util.Random;
import java.util.Scanner;

class GamePlay {
    int myMoney = 100;
    int botMoney = 120;
    int numStage = 1;
    int turn = 0;
    String player1;

    public void RegisterPlayer() {

        System.out.println("플레이어 이름을 입력하세요");
        Scanner sc = new Scanner(System.in);
        player1 = sc.nextLine();
    }

    public void Bot() {
        botMoney = (int) (myMoney * Math.pow(1.2, numStage));
        System.out.println(">>> 상대방 소지금 : " + botMoney + " 원");
    }

    public int randomNumber() {
        Random random = new Random();
        return random.nextInt(20) + 1;
    }

    public void repeat() {
        while (myMoney != 0 && botMoney != 0) {
            pick();
        }
        finalResult();
    }

    public void pick() {

        System.out.println("[홀: 1] , [짝: 2] 입력");
        Scanner sc = new Scanner(System.in);
        int pick = sc.nextInt();

        while (pick != 1 && pick != 2) {
            System.out.println(" [홀: 1] , [짝: 2] 중에 하나를 입력해주세요");
            pick = sc.nextInt();
        }

        System.out.println("얼마를 베팅하시겠습니까? 최대 베팅 가능 금액 : " + Math.min(myMoney, botMoney) + " 원");
        Scanner sc1 = new Scanner(System.in);
        int bet = sc1.nextInt();
        while (bet < 0) {
            System.out.println("양수를 입력해주세요. 최대 베팅 가능 금액 : " + Math.min(myMoney, botMoney) + " 원");
            sc1 = new Scanner(System.in);
            bet = sc1.nextInt();
        }
        if (bet > Math.min(myMoney, botMoney)) {
            System.out.println("최대 금액으로 베팅 : " + Math.min(myMoney, botMoney) + " 원");
            bet = Math.min(myMoney, botMoney);
        }
        result(pick, bet);
    }

    public void result(int pick, int bet) {
        int number = randomNumber();
        if (pick == 1) {
            System.out.println("홀을 선택하셨습니다");
            if (number % 2 == 1) {
                System.out.println("홀! 정답입니다!");
                win(bet);
            }
            if (number % 2 == 0) {
                System.out.println("짝! 틀렸습니다!");
                lose(bet);
            }
        }
        if (pick == 2) {
            System.out.println("짝을 선택하셨습니다");
            if (number % 2 == 1) {
                System.out.println("홀! 틀렸습니다!");
                lose(bet);
            }
            if (number % 2 == 0) {
                System.out.println("짝! 정답입니다!");
                win(bet);
            }
        }
        turn++;
        System.out.println("<소지금>  " + player1 + " : " + myMoney + " 원" + "   상대방 : " + botMoney + " 원");
    }

    public void win(int bet) {
        botMoney -= bet;
        myMoney += bet;
    }

    public void lose(int bet) {
        botMoney += bet;
        myMoney -= bet;
    }


    public void finalResult() {
        if (numStage < 8) {
            if (myMoney == 0) {
                System.out.print(player1 + " 패배!!");
                System.out.println("  Level : " + numStage + "   " + "턴 수 : " + turn);
            }

            if (myMoney != 0) {
                System.out.print(player1 + " 승리!!");
                System.out.println("  Level : " + numStage + "   " + "턴 수 : " + turn);
                System.out.println("----------------------------");
                System.out.println("HERE COMES A NEW CHALLENGER");
                System.out.println("----------------------------");
                turn = 0;
                numStage++;
                Bot();
            }
        }
        if (numStage == 8) {
            System.out.println("-------------------");
            System.out.println(player1 + " 최종 우승!!");
            System.out.println("-------------------");
            System.out.println("Level : " + numStage + "   " + "턴 수 : " + turn);
            numStage++;
        }
    }
}

public class OddEven {
    public static void main(String[] args) {
        GamePlay game = new GamePlay();
        game.RegisterPlayer();
        while (game.myMoney != 0 && game.numStage < 9) {
            game.repeat();
        }
    }
}
