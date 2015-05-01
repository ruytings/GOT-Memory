
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class MenuFrame extends JFrame {
    
    private MenuPanel m;
    private MemoryGame game;
    
    public MenuFrame(final MemoryGame game) {
        super("Game of Thrones: Memory Game");
        this.game = game;
        m = new MenuPanel(new MemoryGame());
        this.add(m, BorderLayout.CENTER);
        this.setSize(400, 400);
        this.setVisible(true);
        this.setResizable(false); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createListeners(game);
    }

    private void createListeners(final MemoryGame game) {
        JButton b1 = m.getButtons().get(0);
        JButton b2 = m.getButtons().get(1);
        JButton b3 = m.getButtons().get(2);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                create();
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog("Kies de naam van speler 1.");
                if(!name.isEmpty()) {
                    game.getPlayer1().setName(name);
                }
                String name2 = JOptionPane.showInputDialog("Kies de naam van speler 2.");
                if(!name2.isEmpty()) {
                    game.getPlayer2().setName(name2);
                }
                create();
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuFrame.this.setVisible(false); 
                MenuFrame.this.dispose();
            }
        });
    }
    
    private void create() {
        Object[] options = {"Klein (8 paren)",
                    "Medium (16 paren)",
                    "Groot (20 paren)"};
        int n = JOptionPane.showOptionDialog(this, "Kies de grootte van het speelveld.", "Speelveld instellen", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
        System.out.print(n);
        setVisible(false); 
        dispose();
        MemoryGameFrame gameFrame = new MemoryGameFrame(game, n);
    }
    
    public static void main(String args[]) {
        MenuFrame m = new MenuFrame(new MemoryGame());
    }
}
