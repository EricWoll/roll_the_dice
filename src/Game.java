import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private byte playerNumber;
    private ArrayList<Player> playerList = new ArrayList();
    private String deadPlayer;

    private Scanner userInput;

    private static void printCopyright() {
        System.out.println("====================");
        System.out.println("    Roll the Dice");
        System.out.println("    by Eric Woll");
        System.out.println("====================\n");
    }

    public void setPlayerNumber(byte playerNumber) {
        this.playerNumber = playerNumber;
    }

    public void gameLoop() {
        Boolean keepPlaying = true;

        while (keepPlaying) {

            // Print Copyright
            // Ask for names (2 player)
            // ask for roll input


            rollDice();

            deadPlayer = checkPlayerHealth();

            if (deadPlayer != "None") {

                // Clear output
                keepPlaying = playAgainCheck();
            }
        }
    }

    private boolean playAgainCheck() {
        String response = new String();
        while (true) {
            System.out.println("Would you like to play again (y/n)? ");
            response = userInput.nextLine().toLowerCase();

            switch (response) {
                case "y" -> {return true;}
                case "n" -> {return false;}
                default -> {
                    //Clear output
                    System.out.println(" '" + response + "' was not an appropriate input. Please try again.");
                }
            }
        }
    }

    private void rollDice() {
        for (Player p : playerList) {
            p.generateRoll();
        }
    }

    public void addPlayers(Player newPlayer) {
        playerList.add(newPlayer);
    }

    private String checkPlayerHealth() {
        for (Player p : playerList) {
            if (p.getLives() == 0) {
                return p.getName();
            }
        }
        return "None";
    }

    public String getDeadPlayer() {
        return deadPlayer;
    }

    public void printPlayers() {
        for (Player p : playerList) {
            System.out.println(p.getName());
        }
    }
}
