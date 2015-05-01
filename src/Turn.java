
import javax.swing.JButton;


public class Turn {
    
    private MemoryGame game;
    private Player p;
    private Character c1, c2;
    private boolean isFinished = false;

    public Turn(MemoryGame game, Player p) {
        this.p = p;
        this.game = game;
        p.setPlaying(true);
    }
    
    public boolean isCorrect() {
        return c1.equals(c2);
    }

    public void setC1(Character c1) {
        this.c1 = c1;
    }

    public void setC2(Character c2) {
        this.c2 = c2;
    }

    public Character getC1() {
        return c1;
    }

    public Character getC2() {
        return c2;
    }

    public Player getPlayer() {
        return p;
    }

    
}
