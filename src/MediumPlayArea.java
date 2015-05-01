
import java.awt.GridLayout;


public class MediumPlayArea extends PlayArea {

    public MediumPlayArea(MemoryGame game) {
       super(game);
       this.setLayout(new GridLayout(4, 6, 3, 3)); 
    }
    
}
