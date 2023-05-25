import java.util.Random;
public class Player {
    private String name;
    private byte lives = 3;
    private byte roll;
    private Random numberGenerator = new Random();

    public Player(String name) {
        this.name = name;
    }
    public void removeLife() {
        lives--;
    }
    public void resetLives() {
        lives = 3;
    }
    public void generateRoll() {
        roll = (byte) (numberGenerator.nextInt(6) + 1);
    }
    public byte getRoll() {
        return roll;
    }
    public String getName() {
        return name;
    }

    public byte getLives() {
        return lives;
    }

    public void setLives(byte livesNumber) {
        lives = livesNumber;
    }
}
