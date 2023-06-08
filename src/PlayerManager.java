import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

public class PlayerManager {
    // PlayerController -> polymorphism to allow Player and AI
    private Dictionary<String, PlayerController> playerList = new Hashtable<>();

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
        for (Enumeration e = playerList.elements(); e.hasMoreElements();) {
            playerList.get(e.nextElement()).getRoll();
        }
    }
    public boolean checkContinuePlaying() {
        /**
         * @param none
         * @return boolean all players agree to continue playing
         */
        PlayerController currPlayer;
        for (Enumeration e = playerList.elements(); e.hasMoreElements();) {
            currPlayer = playerList.get(e.nextElement());
            if (currPlayer.isAi() && currPlayer.getContinuePlaying()) {
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
        PlayerController currPlayer;
        for (Enumeration e = playerList.elements(); e.hasMoreElements();) {
            currPlayer = playerList.get(e.nextElement());
            if (currPlayer.getLives() <= 0) {
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
        PlayerController currPlayer = null;
        for (Enumeration e = playerList.elements(); e.hasMoreElements();) {
            currPlayer = playerList.get(e.nextElement());
            if (currPlayer.getLives() <= 0) {
                break;
            }
        }
        return currPlayer;
    }
    public PlayerController getWinner() {
        /**
         * @param none
         * @return PlayerController object or null if no match found
         */
        PlayerController currPlayer = null;
        for (Enumeration e = playerList.elements(); e.hasMoreElements();) {
            currPlayer = playerList.get(e.nextElement());
            if (currPlayer.getLives() > 0) {
                break;
            }
        }
        return currPlayer;
    }

    public void resetGame() {
        /**
         * Resets game (lives)
         * @param none
         * @return none
         */
        PlayerController currPlayer = null;
        for (Enumeration e = playerList.elements(); e.hasMoreElements();) {
            currPlayer = playerList.get(e.nextElement());
            currPlayer.setLives(currPlayer.getMaxLives());
        }
    }
}
