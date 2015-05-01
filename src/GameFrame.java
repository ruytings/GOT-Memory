
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JMenuBar;


public class GameFrame extends JFrame {
    
    JMenuBar menuBar;
    
    public GameFrame(Game game, String title) {
        super(title);
        menuBar = new MenuBar(this, game);
        this.setJMenuBar(menuBar);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setSize(screenSize);
        this.setVisible(true);    
        this.setResizable(false); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
