
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;


public class PlayersPanel extends JPanel implements Observer {
    
    private MemoryGame game;
    private JLabel l1, l2;
    private BufferedImage image;
    
    public PlayersPanel(MemoryGame game) {
        super();
        this.game = game;
        game.addObserver(this);
        this.setLayout(new GridLayout(2, 1, 0, 30));
        Font font = new Font("Verdana", Font.BOLD, 15);
        Font titleFont = new Font("Verdana", Font.BOLD, 18);
        l1 = new JLabel("" + game.getPlayer1().getScore());
        l1.setForeground(Color.WHITE);
        l1.setFont(font);
        l1.setHorizontalAlignment(SwingConstants.CENTER);
        l2 = new JLabel("" + game.getPlayer2().getScore());
        l2.setForeground(Color.WHITE);
        l2.setFont(font);
        l2.setHorizontalAlignment(SwingConstants.CENTER);
        TitledBorder tb1 = new TitledBorder("Score " + game.getPlayer1().getName() + ": ");
        tb1.setTitleFont(titleFont);
        tb1.setTitleColor(Color.WHITE);
        TitledBorder tb2 = new TitledBorder("Score " + game.getPlayer2().getName() + ": ");
        tb2.setTitleFont(titleFont);
        tb2.setTitleColor(Color.WHITE);
        l2.setPreferredSize(new Dimension(250, 10));  
        l1.setBorder(tb1);
        l2.setBorder(tb2);
        this.add(l1);
        this.add(l2);
        try {
           image = ImageIO.read(getClass().getResource("background2.jpg"));
            
        } catch (IOException ex) {
            Logger.getLogger(PlayArea.class.getName()).log(Level.SEVERE, null, ex);
        }
        revalidate();
        repaint();
        
    }
    
    @Override
    protected void paintComponent(Graphics g) {
    super.paintComponent(g);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }

    @Override
    public void update() {
        l1.setText(""+game.getPlayer1().getScore());
        l2.setText(""+game.getPlayer2().getScore());
    }
}
