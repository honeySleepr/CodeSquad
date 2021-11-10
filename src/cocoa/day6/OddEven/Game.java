package cocoa.day6.OddEven;

import java.util.Random;
import java.util.Scanner;

public class Game {
    int myMoney; //대입은 생성할 때 하자
    int botMoney;
    int numStage;        //todo : 테스트용
    int turn;
    Player player = new Player();//  호눅스는 왜 private 을 쓰는걸까?

    public Game() {             // 생성자!
        this.myMoney = 100;
        this.botMoney = 120;
        this.numStage = 1;
        this.turn = 0;

    }

    public void bot() {
        botMoney = (int) (getMyMoney() * Math.pow(1.2, numStage));
        System.out.println(">>> 상대방 소지금 : " + getBotMoney() + " 원");
    }

    public int getMyMoney() {
        return myMoney;
    }

    public int getBotMoney() {
        return botMoney;
    }


    public int randomNumber() {
        Random random = new Random();
        return random.nextInt(20) + 1;
    }

    public void play() {
        while (myMoney != 0 && botMoney != 0) {
            pick();
        }
        finalResult();
    }

    public void pick() {
        int number = randomNumber();
        System.out.println("blackSheepWall : " + number);           // todo: 테스트용
        System.out.print("[홀: 1] [짝: 2] 입력 :  ");
        Scanner sc = new Scanner(System.in);
        int pick = sc.nextInt();

        while (pick != 1 && pick != 2) {
            System.out.println(" [홀: 1] , [짝: 2] 중에 하나를 입력해주세요");
            pick = sc.nextInt();
        }

        System.out.println("얼마를 베팅하시겠습니까? 최대 베팅 가능 금액 : " + Math.min(myMoney, botMoney) + " 원");
        int bet = sc.nextInt();
        while (bet < 0) {
            System.out.println("양수를 입력해주세요. 최대 베팅 가능 금액 : " + Math.min(myMoney, botMoney) + " 원");
            bet = sc.nextInt();
        }
//        sc.close();   ????
        if (bet > Math.min(myMoney, botMoney)) {
            System.out.println("최대 금액으로 베팅 : " + Math.min(myMoney, botMoney) + " 원");
            bet = Math.min(myMoney, botMoney);

        }
//        sc.close();   ????
        result(number, pick, bet);
//        sc.close();   ????
    }

    public void result(int number, int pick, int bet) {
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
        System.out.println("<소지금>  " + player.player1 + " : " + myMoney + " 원" + "   상대방 : " + botMoney + " 원");
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
                System.out.print(player.player1 + " 패배!!");
                System.out.println("  Level : " + numStage + "   " + "턴 수 : " + turn);
            }

            if (myMoney != 0) {
                System.out.print(player.player1 + " 승리!!");
                System.out.println("  Level : " + numStage + "   " + "턴 수 : " + turn);
                System.out.println("----------------------------");
                System.out.println("HERE COMES A NEW CHALLENGER");
                System.out.println("----------------------------");
                turn = 0;
                numStage++;
                Game game = new Game();
                bot();
            }
        }
        if (numStage == 8) {
            System.out.println("-------------------");
            System.out.println(player.player1 + " 최종 우승!!");
            System.out.println("-------------------");
            System.out.println("Level : " + numStage + "   " + "턴 수 : " + turn);
            System.out.println(myMoney);
            numStage++;
        }

    }
}
