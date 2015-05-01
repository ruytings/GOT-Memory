
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
    
    private PlayArea p;
    private ScorePanel s;
    private BufferedImage image;
    
    public GamePanel(PlayArea p, ScorePanel s) {
        super();
        this.p = p;
        this.s = s;
        add(p, BorderLayout.WEST);
	add(s, BorderLayout.EAST);
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
    
   
    
}
