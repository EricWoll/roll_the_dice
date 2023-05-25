import java.util.ArrayList;
import java.util.Scanner;

public class PlayerManager {
    private ArrayList<Player> playerList = new ArrayList();
    private Scanner userInput;

    private void addPlayer(Player newPlayer) {
        playerList.add(newPlayer);
    }

    public void createPlayer(String name) {
        Player p = new Player(name);
        addPlayer(p);
    }

    public void removePlayer(Player player) {
        playerList.remove(player.getClass());
    }
    public void rollDice() {
        for (Player p : playerList) {
            p.generateRoll();
        }
    }

    public String checkPlayerHealth() {
        for (Player p : playerList) {
            if (p.getLives() == 0) {
                return p.getName();
            }
        }
        return "None";
    }

    public void printPlayers() {
        for (Player p : playerList) {
            System.out.println(p.getName());
        }
    }
}
