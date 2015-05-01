
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class Character extends JButton {
    
    private String name = "Onbekend";
    private String image;
    private static final String backImage = "backImage.png";
    private boolean guessed = false;
    
    public Character(String name, String image) {
        super();
        setBorder(BorderFactory.createLineBorder(new Color(0x808080), 4));
        setSize(150, 150);
        setMinimumSize(new Dimension(150, 150));
        setMaximumSize(new Dimension(150, 150));
        setDisabledIcon(new ImageIcon(this.getClass().getResource(image)));
        setIcon(new ImageIcon(this.getClass().getResource(backImage)));
        this.image = image;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getBackImage() {
        return backImage;
    }
    
    public boolean equals(Object object) {
        boolean equal = false;
        if(object instanceof Character) {
            Character c = (Character) object;
            if(c.getName().equals(name)) {
                equal = true;
            }
        }
        return equal;
    }

    public void setGuessed(boolean b) {
        this.guessed = b;
    }
    
    public boolean getGuessed() {
        return guessed;
    }
    
    public String toString() {
        return name;
    }
    
}

