package cocoa.day6.OddEven;

import java.util.Scanner;

public class Player {
    public String player1;
    Game game;
    // public? private? 빈칸?

    public Player(Game game) {
        this.game = game;
    }

    public void registerPlayer() {

        System.out.print("플레이어 이름을 입력하세요 : ");
        Scanner sc = new Scanner(System.in);
        player1 = sc.nextLine();
//        sc.close();   ????
    }

}
