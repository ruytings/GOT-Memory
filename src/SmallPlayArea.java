
import java.awt.GridLayout;


public class SmallPlayArea extends PlayArea {

    public SmallPlayArea(MemoryGame game) {
       super(game);
       this.setLayout(new GridLayout(4, 4, 3, 3)); 
    }
    
}
