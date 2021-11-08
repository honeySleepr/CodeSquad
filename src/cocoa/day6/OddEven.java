package cocoa.day6;

import java.util.Random;
import java.util.Scanner;

class Player {
    int myMoney = 100;


    public String RegisterPlayer() {

        System.out.println("플레이어 이름을 입력하세요");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println("Player #1 :" + name);  // 지워도 될듯

        return name;
    }


}

class Bot {
    int botMoney = 120;
//    Todo : 다음 단계 Bot 설계


}

class GamePlay {
    public int randomNumber() {
        Random random = new Random();
        int number = random.nextInt(20);
        System.out.println(number);  // 임시 확인용. 실제 게임 중에는 보여지지 않음
        return number;
    }

    public void pick() {
        Bot bot = new Bot();
        Player my = new Player();
//        선택
        System.out.println("홀: 1 , 짝: 2 입력");
        Scanner sc = new Scanner(System.in);
        int pick = sc.nextInt();
        while(pick != 1 && pick != 2) {
            System.out.println(" 홀: 1 , 짝: 2 중에 하나를 입력해주세요");
            pick = sc.nextInt();
        }
//        베팅


//        System.out.println(num);
        System.out.println("얼마를 베팅하시겠습니까? 최대 베팅 가능 금액:" + Math.min(my.myMoney, bot.botMoney));
        Scanner sc1 = new Scanner(System.in);
        int bet = sc1.nextInt();

        int number = randomNumber();
        if (pick == 1) {
            System.out.println("홀을 선택하셨습니다");
            System.out.println("과연?");
            if (number % 2 == 1) {
                System.out.println("홀! 정답입니다!");
//                myMoney
            }
            if (number % 2 == 0) {
                System.out.println("짝! 틀렸습니다ㅠㅠ");

            }
        }
        if (pick == 2) {
            System.out.println("짝을 선택하셨습니다");
            System.out.println("과연?");
            System.out.println(number);
            if (number % 2 == 1) {
                System.out.println("홀! 틀렸습니다ㅠㅠ");

            }
            if (number % 2 == 0) {
                System.out.println("짝! 정답입니다!");

            }
        }
    }

}

public class OddEven {
    public static void main(String[] args) {

        Player player = new Player();
        player.RegisterPlayer();
        GamePlay game = new GamePlay();
        game.pick();
    }
}
// todo : 플레이어 홀짝 입력 후 배팅금 입력
