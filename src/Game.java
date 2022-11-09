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
        Point point = switch (players.size()) {
            case 0 -> new Point(0, 0);
            case 1 -> new Point(gameMap.ROWS - 1, 0);
            case 2 -> new Point(0, gameMap.COLUMNS - 1);
            case 3 -> new Point(gameMap.COLUMNS - 1, gameMap.ROWS - 1);
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



}