
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MenuBar extends JMenuBar {
    
    private JMenu m1;
    private JMenuItem i1, i2, i3, i4;
    
    public MenuBar(final GameFrame frame, final Game game) {
        super();
        m1 = new JMenu("Spel");
        this.add(m1);
        i1 = new JMenuItem("Herstarten");
        i1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               frame.setVisible(false);
               frame.dispose();
               Game newGame = new MemoryGame();
               newGame.getPlayer1().setName(game.getPlayer1().getName());
               newGame.getPlayer2().setName(game.getPlayer2().getName());
               MemoryGame mGame = (MemoryGame) newGame;
               Object[] options = {"Klein (8 paren)",
                    "Medium (12 paren)",
                    "Groot (20 paren)"};
               int n = JOptionPane.showOptionDialog(frame, "Kies de grootte van het speelveld.", "Speelveld instellen", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
               MemoryGameFrame gameFrame = new MemoryGameFrame(mGame, n);
            }
        });
        i2 = new JMenuItem("Terug naar menu");
        i2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               frame.setVisible(false);
               frame.dispose();
               MenuFrame newFrame = new MenuFrame(new MemoryGame());
            }
        });
        i3 = new JMenuItem("Afsluiten");
        i3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               frame.setVisible(false);
               frame.dispose();
            }
        });
        m1.add(i1);
        m1.add(i2);
        m1.addSeparator();
        m1.add(i3);
    }
}
