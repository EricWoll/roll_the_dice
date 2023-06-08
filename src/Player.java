public class Player extends PlayerController {

    private boolean continuePlaying;

    public Player(boolean isAi, byte lives) {
        super(isAi, lives);
    }

    public void setContinuePlaying(boolean continuePlaying) {
        this.continuePlaying = continuePlaying;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getContinuePlaying() {
        return continuePlaying;
    }
}
