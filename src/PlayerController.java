import java.util.Random;

public class PlayerController {
    protected String name;
    private byte roll;
    private byte lives;
    private final byte maxLives;
    private boolean isAi;
    private Random randDie = new Random();

    public PlayerController(boolean isAi, byte lives ) {
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
    public byte getRoll() {
        return roll;
    }
    public byte getLives() { return lives; }
    public byte getMaxLives() { return maxLives; }
    public boolean isAi() {
        return isAi;
    }
    public void setLives(byte lives) { this.lives = lives; }
}