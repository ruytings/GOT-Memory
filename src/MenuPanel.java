
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;


public class MenuPanel extends JPanel {
    
    private BufferedImage image;
    private ArrayList<JButton> buttons; 
    private MemoryGame game;
    
    public MenuPanel(final MemoryGame game) {
        super();
        this.game = game;
        this.setLayout(new GridLayout(3, 1, 20, 20));
        Font titleFont = new Font("Verdana", Font.BOLD, 18);
        TitledBorder tb3 = new TitledBorder("Menu: ");
        tb3.setTitleColor(Color.WHITE);
        tb3.setTitleFont(titleFont);
        this.setBorder(tb3);
        try {
           image = ImageIO.read(getClass().getResource("background2.jpg"));
            
        } catch (IOException ex) {
            Logger.getLogger(PlayArea.class.getName()).log(Level.SEVERE, null, ex);
        }
        revalidate();
        repaint();
        buttons = new ArrayList<JButton>(2);
        Font font = new Font("Verdana", Font.BOLD, 15);
        JButton b1 = new JButton("Snel beginnen");
        JButton b2 = new JButton("Namen kiezen");
        JButton b3 = new JButton("Afsluiten");
        buttons.add(b1);
        buttons.add(b2);
        buttons.add(b3);
        for(JButton b : buttons) {
            b.setAlignmentX(Component.CENTER_ALIGNMENT);
            b.setFont(font);
            b.setBackground(new Color(0x808080));
            b.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
            b.setPreferredSize(new Dimension(250, 100));
            b.setFocusable(false);
            this.add(b);
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
    super.paintComponent(g);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }

    public ArrayList<JButton> getButtons() {
        return buttons;
    }
    
    
    
    
}
