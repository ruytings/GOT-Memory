
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;


public class MemoryGameFrame extends GameFrame{
    
    public MemoryGameFrame(MemoryGame game, int n) {
        super(game, "Game of Thrones: Memory Game");
        game.setSize(n);
        game.readXML();
        PlayArea p;
        if(game.getSize() == 0) {
            p = new SmallPlayArea(game);
        } else if(game.getSize() == 1) {
            p = new MediumPlayArea(game);
        } else p = new LargePlayArea(game);
        ScorePanel s = new ScorePanel(game);
        GamePanel gamePanel = new GamePanel(p, s);
        this.getContentPane().add(gamePanel);
    }

}
