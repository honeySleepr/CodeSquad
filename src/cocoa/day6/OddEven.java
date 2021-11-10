package cocoa.day6;

public class OddEven {
    public static void main(String[] args) {
        Game game = new Game();
        game.init();
        while (game.myMoney != 0 && game.numStage < 9) {
            game.repeat();
        }
    }
}



