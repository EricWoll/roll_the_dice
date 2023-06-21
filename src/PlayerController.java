import java.util.Random;

public class PlayerController {
    protected String name;
    private byte roll;
    private int lives;
    private final int maxLives;
    private boolean isAi;
    private Random randDie = new Random();

    public PlayerController(boolean isAi, int lives ) {
        this.isAi = isAi;
        this.lives = lives;
        maxLives = lives;
    }

    public void generateRoll() {
        roll = (byte) (randDie.nextInt(6) + 1);
    }
    public String getName() {
        return name;
    }
    public void setName() {
        name = "Name not set";
    }
    public byte getRoll() {
        return roll;
    }
    public int getLives() { return lives; }
    public int getMaxLives() { return maxLives; }
    public boolean isAi() {
        return isAi;
    }
    public void setLives(int livesUpdate) {
        if (livesUpdate > lives) { lives = maxLives; }
        else if (livesUpdate < 0) { lives = 0; }
        else { lives = livesUpdate; }
    }
    public void removeLife() { lives-=1; }
}
