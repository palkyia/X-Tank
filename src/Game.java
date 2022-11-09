import java.awt.*;
import java.util.ArrayList;

public class Game {
    private Grid grid;
    private ArrayList<Player> players;
    final int MAX_PLAYER_COUNT = 4;
    public Game(){
        grid = new GridA();
        players = new ArrayList<Player>();
    }

    public Grid getGrid(){
        return this.grid;
    }
    public void addPlayer(Player player){
        // spawn points for each player
        Point point = switch (players.size()) {
            case 0 -> new Point(0, 0);
            case 1 -> new Point(19, 0);
            case 2 -> new Point(0, 14);
            case 3 -> new Point(19, 14);
            default -> null;
        };
        if (point == null) {
            return;
        }
        Tank tank = new Tank(point);
        grid.setItem(point.x, point.y, tank);
        player.setTank(tank);
        players.add(player);

    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}
