
public class Player {
    
    private String name;
    private boolean playing = false;
    private int score;
    
    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isPlaying() {
        return playing;
    }

    public int getScore() {
        return score;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    public void addOne() {
        this.score += 1;
    }

    public void setName(String player1) {
        this.name = player1;
    }
    
    @Override
    public boolean equals(Object o) {
        boolean isEqual = false;
        if(o instanceof Player) {
            Player p = (Player)o;
            if(p.getName().equals(name)) {
                isEqual = true;
            }
        }
        return isEqual;
    }
    
 
    
}
