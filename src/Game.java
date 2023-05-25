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

    public void gameLoop() {

        Tools.printCopyright();

        while (true) {
            System.out.println("How many players will be playing? ");
            try {
                playerAmount = (byte) userInput.nextInt();
                if (playerAmount > 0) {
                    setPlayerNumber(playerAmount);
                    break;
                } else {
                    throw new Exception();
                }

            } catch (Exception e) {
                System.out.println("That value is not excepted. Try a positive whole number greater than 0.");
            }
        }

        while (!stopPlaying) {

            for (byte i = 0; i < playerAmount; i++) {
                System.out.print("Enter your name Player" + (i+1) + ": ");
                playerManager.createPlayer(userInput.nextLine());
            }

            Tools.enterToContinue("Press enter to roll your dice!");

            playerManager.rollDice();

            deadPlayer = playerManager.checkPlayerHealth();

            if (!deadPlayer.equals("None")) {
                stopPlaying = !responseIsYes("Would you like to play again (y/n)? ");
            }
        }

    }

    public Boolean responseIsYes(String visualOutput) {
        Scanner userInput = new Scanner(System.in);
        String response;

        while (true) {
            System.out.println(visualOutput);
            response = userInput.nextLine().toLowerCase();

            switch (response) {
                case "y" -> {return true;}
                case "n" -> {return false;}
                default -> {
                    System.out.println(
                            " '" + response
                            + "' was not an appropriate input. Please try again."
                    );
                }
            }
        }
    }
}
