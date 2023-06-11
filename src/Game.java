import java.util.Scanner;

public class Game {
    private byte playerNumber;
    private String deadPlayer;
    private byte playerAmount;
    private Scanner userInput = new Scanner(System.in);
    private PlayerManager playerManager = new PlayerManager();
    private Boolean stopPlaying;

    private void setPlayerNumber(byte playerNumber) {

        this.playerNumber = playerNumber;
    }

    public void run() {
        gameLoop();
    }

    private void gameLoop() {
        while (true) {

        }
    }
}
