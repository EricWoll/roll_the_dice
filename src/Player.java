import java.util.Random;
public class Player {
    private String playerName;
    private byte lives = 3;
    private byte roll;
    private Random numberGenerator = new Random();

    public Player(String name) {
        playerName = name;
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

        return playerName;
    }

    public byte getLives() {

        return lives;
    }

    public void setLives(byte livesNumber) {

        lives = livesNumber;
    }
}
