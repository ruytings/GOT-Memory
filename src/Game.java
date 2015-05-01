
public abstract class Game {
    
    protected Player player1, player2;
    
    public Game() {
        player1 = new Player("Player 1");
        player2 = new Player("Player 2");
    }

    abstract void initGame();

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
    
}
