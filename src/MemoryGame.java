
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import org.jdom2.*;
import org.jdom2.input.SAXBuilder;

public class MemoryGame extends Game implements Subject {

    private ArrayList<Character> characters = new ArrayList<Character>();
    private Turn currentTurn;
    private ArrayList<Observer> observers = new ArrayList<Observer>();
    private String status;
    private int size = -1;
    private int number = -1;

    public MemoryGame() {
        super();
    }

    public ArrayList<Character> getCharacters() {
        return characters;
    }

    public boolean isFinished() {
        if (player1.getScore() + player2.getScore() == number) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void initGame() {
        for (Character c : characters) {
            CreateListener(c);
        }
    }

    private void CreateListener(final Character c) {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentTurn.getC1() == null && currentTurn.getC2() == null) {
                    currentTurn.setC1(c);
                    c.setIcon(new ImageIcon(c.getClass().getResource(c.getImage())));
                    c.setBorder(BorderFactory.createLineBorder(new Color(0xea8600), 4));
                    currentTurn.getC1().setEnabled(false);
                } else if (currentTurn.getC1() != null && currentTurn.getC2() == null) {
                    currentTurn.setC2(c);
                    c.setIcon(new ImageIcon(c.getClass().getResource(c.getImage())));
                    if (currentTurn.isCorrect()) {
                        c.setGuessed(true);
                        currentTurn.getC1().setGuessed(true);
                        currentTurn.getC1().setEnabled(false);
                        currentTurn.getC2().setEnabled(false);
                        c.setBorder(BorderFactory.createLineBorder(new Color(0x5bdd00), 4));
                        currentTurn.getC1().setBorder(BorderFactory.createLineBorder(new Color(0x5bdd00), 4));
                        status = "Bravo! Je vond " + c.toString() + ".";
                        currentTurn.getPlayer().addOne();
                        if (isFinished()) {
                            if (player1.getScore() > player2.getScore()) {
                                status = player1.getName() + " heeft gewonnen!";
                            } else if (player2.getScore() > player1.getScore()) {
                                status = player2.getName() + " heeft gewonnen!";
                            } else {
                                status = "Het spel eindigde in een gelijkspel.";
                            }
                        }
                    } else {
                        currentTurn.getC1().setEnabled(true);
                        c.setBorder(BorderFactory.createLineBorder(new Color(0xea8600), 4));
                        status = "Helaas! Je vond niemand.";
                    }
                    notifyObservers();
                }

            }
        };
        c.addActionListener(listener);
    }

    public Turn getCurrentTurn() {
        return currentTurn;
    }

    public void setCurrentTurn(Turn currentTurn) {
        this.currentTurn = currentTurn;
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update();
        }
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public String getStatus() {
        return status;
    }

    public void readXML() {
        try {
            
            Document doc = new SAXBuilder(false).build(this.getClass().getResource("characters.xml"));
            Element root = doc.getRootElement();
            List list = root.getChildren("character");
            if(size == 0) {
                number =  8;
            } else if (size == 1) {
                number = 12;
            } else number = 20;
            for (int i = 0; i < number; i++) {
                Element node = (Element) list.get(i);
                String name = node.getChildText("name");
                String image = node.getChildText("image");
                characters.add(new Character(name, image));
                characters.add(new Character(name, image));
            }
        } catch (Exception ex) {
            Logger.getLogger(MemoryGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        Collections.shuffle(characters);
        currentTurn = new Turn(this, player1);
        initGame();
    }

    public void setStatus(String string) {
        this.status = status;
    }
    
    public int getSize() {
        return size;
    }
    
    public void setSize(int size) {
        this.size = size;
    }
    
    

}
