import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayArea extends JPanel implements Observer {
    
    private MemoryGame game;
    private JLabel l1, l2;
    private BufferedImage image;
    
    public PlayArea(MemoryGame game) {
        super();
        this.game = game;
        game.addObserver(this);
        try {
           image = ImageIO.read(getClass().getResource("background2.jpg"));
            
        } catch (IOException ex) {
            Logger.getLogger(PlayArea.class.getName()).log(Level.SEVERE, null, ex);
        }
        update();
        for(int i = 0; i < game.getCharacters().size(); i++) {
            this.add(game.getCharacters().get(i));
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
    super.paintComponent(g);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }

    @Override
    public void update() {
        for(Character c : game.getCharacters()) {
            c.revalidate();
            c.repaint();
        }
        revalidate();
        repaint();
    }
    
   
    
}
    

