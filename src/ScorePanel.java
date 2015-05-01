
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class ScorePanel extends JPanel implements Observer {

    private MemoryGame game;
    private JLabel l3;
    private PlayersPanel p;
    private JButton b1;
    private BufferedImage image;

    public ScorePanel(final MemoryGame game) {
        super();
        this.game = game;
        game.addObserver(this);
        this.setLayout(new GridLayout(4, 1, 50, 100));
        Font font = new Font("Verdana", Font.BOLD, 10);
        Font titleFont = new Font("Verdana", Font.BOLD, 18);
        p = new PlayersPanel(game);
        b1 = new JButton("Verdergaan");
        b1.setFont(font);
        b1.setBackground(new Color(0x808080));
        b1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        b1.setEnabled(false);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!game.isFinished()){
                    game.notifyObservers();
                    b1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
                    if (game.getCurrentTurn().getC1() != null && game.getCurrentTurn().getC2() != null) {
                        for (Character c : game.getCharacters()) {
                            if (!c.getGuessed()) {
                                c.setBorder(BorderFactory.createLineBorder(new Color(0x808080), 4));
                                c.setIcon(new ImageIcon(this.getClass().getResource(Character.getBackImage())));
                            }
                        }
                        if (game.getCurrentTurn().getPlayer().equals(game.getPlayer1())) {
                            if(!game.getCurrentTurn().isCorrect()) {
                                game.setCurrentTurn(new Turn(game, game.getPlayer2()));
                                game.getPlayer1().setPlaying(false);
                            } else game.setCurrentTurn(new Turn(game, game.getPlayer1()));
                        } else {
                            if(!game.getCurrentTurn().isCorrect()) {
                                game.setCurrentTurn(new Turn(game, game.getPlayer1()));
                                game.getPlayer2().setPlaying(false);
                                game.getPlayer1().setPlaying(true);
                            } else game.setCurrentTurn(new Turn(game, game.getPlayer2()));
                        } 
                        l3.setText(game.getCurrentTurn().getPlayer().getName() + " is aan de beurt.");
                        b1.setEnabled(false);
                    }
                } else {
                    l3.setText(game.getStatus());
                }
            } 
        });
        b1.setFocusable(false);
        l3 = new JLabel(game.getCurrentTurn().getPlayer().getName() + " is aan de beurt.");
        l3.setForeground(Color.WHITE);
        l3.setFont(font);
        l3.setPreferredSize(new Dimension(250, 10));
        TitledBorder tb3 = new TitledBorder("Spelstatus: ");
        tb3.setTitleColor(Color.WHITE);
        tb3.setTitleFont(titleFont);
        l3.setBorder(tb3);
        this.add(p);
        this.add(l3);
        this.add(b1);
        try {
            image = ImageIO.read(getClass().getResource("background3.jpg"));

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
        b1.setEnabled(true);
        b1.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
        l3.setText(game.getStatus());
    }

}
