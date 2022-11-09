import java.awt.*;
import java.util.ArrayList;

public class Game {
    private Grid grid;
    private ArrayList<Player> players;
    final int MAX_PLAYER_COUNT = 4;
    public Game(){
        grid = new GridA();
        players = new ArrayList<>();
    }

    public Grid getGrid(){
        return this.grid;
    }
    public void addPlayer(Player player){
        // spawn points for each player
        String color = null;
        Point point = null;
        switch (players.size()) {
            case 0:
                point = new Point(1, 1);
                color = "green";
            case 1:
                point = new Point(18, 1);
                color = "tan";
            case 2:
                point = new Point(1, 13);
                color = "yellow";
            case 3:
                point = new Point(18, 13);
                color = "purple";

        }
        if (point == null || color.equals(null)) {
            return;
        }
        Tank tank = new Tank(point, color);
        grid.setItem(point.x, point.y, tank);
        player.setTank(tank);
        players.add(player);

    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}
