package cocoa.day6.OddEven;

public class OddEven {
    public static void main(String[] args) {
        Game game = new Game();
        while (game.myMoney != 0 && game.numStage < 9) {
            game.repeat();
        }
    }
}



