import java.util.Enumeration;
import java.util.Map;
import java.util.HashMap;

public class PlayerManager {
    // PlayerController -> polymorphism to allow Player and AI
    private Map<String, PlayerController> playerList = new HashMap<>();

    public void addPlayer(PlayerController player) {
        playerList.put(player.name, player);
    }
    public PlayerController removePlayer (String name) {
        /**
         * @param Player name
         * @return PlayerController object
         */
        PlayerController player = playerList.get(name);
        playerList.remove(name);
        return player;
    }
    public PlayerController getPlayer(String name) {
        return playerList.get(name);
    }
    public byte getPlayerAmount() {
        return (byte)playerList.size();
    }
    public void rollDice() {
        for (Map.Entry<String, PlayerController> currPlayer : playerList.entrySet()) {
            playerList.get(currPlayer.getValue()).getRoll();
        }
    }
    public boolean checkContinuePlaying() {
        /**
         * @param none
         * @return boolean all players agree to continue playing
         */
        boolean playGame = true;
        for (Map.Entry<String, PlayerController> currPlayer : playerList.entrySet()) {
            if(currPlayer.getValue() instanceof Player) {
                playGame = ((Player)currPlayer.getValue()).getContinuePlaying();
            }
            if (!playGame) {
                return false;
            }
        }
        return true;
    }
    public boolean checkForLooser() {
        /**
         * @param none
         * @return boolean game looser found
         */
        for (Map.Entry<String, PlayerController> currPlayer : playerList.entrySet()) {
            if (currPlayer.getValue().getLives() <= 0) {
                return true;
            }
        }
        return false;
    }
    public PlayerController getLooser() {
        /**
         * @param none
         * @return PlayerController object or null if no match found
         **/
        for (Map.Entry<String, PlayerController> currPlayer : playerList.entrySet()) {
            if (currPlayer.getValue().getLives() <= 0) {
                return currPlayer.getValue();
            }
        }
        return null;
    }
    public PlayerController getWinner() {
        /**
         * @param none
         * @return PlayerController object or null if no match found
         */
        for (Map.Entry<String, PlayerController> currPlayer : playerList.entrySet()) {
            if (currPlayer.getValue().getLives() > 0) {
                return currPlayer.getValue();
            }
        }
        return null;
    }

    public void resetGame() {
        for (Map.Entry<String, PlayerController> currPlayer : playerList.entrySet()) {
            currPlayer.getValue().setLives( currPlayer.getValue().getMaxLives() );
        }
    }
}
