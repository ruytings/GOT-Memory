
import java.awt.GridLayout;


public class LargePlayArea extends PlayArea {

    public LargePlayArea(MemoryGame game) {
        super(game);
        this.setLayout(new GridLayout(5, 8, 3, 3));
    }
    
}
