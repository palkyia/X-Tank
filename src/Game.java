import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;

public class Game {
    Grid grid;
    private ArrayList<Player> players;
    private boolean hasWinner;
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
                System.out.println("Player 1 created.");
                point = new Point(1, 1);
                color = "green";
                break;
            case 1:
                System.out.println("Player 2 created.");
                point = new Point(18, 1);
                color = "tan";
                break;
            case 2:
                System.out.println("Player 3 created.");
                point = new Point(1, 13);
                color = "yellow";
                break;
            case 3:
                System.out.println("Player 4 created.");
                point = new Point(18, 13);
                color = "purple";
                break;

        }
        if (point == null) {
            System.out.println("Player creation failed");
            return;
        }
        Tank tank = new Tank(point, color);
        grid.setItem(point.x, point.y, tank);
        player.setTank(tank);
        players.add(player);

    }

    public synchronized void updateDeaths() throws IOException {
        ListIterator<Player> iter = players.listIterator();
        while (iter.hasNext()){
            Player p = iter.next();
            if (p.getTank().isDead()){
                p.getTank().despawn(grid);
                p.getOutput().writeObject(new gameStateMessage(grid, !p.getTank().isDead(), false, p.getTank().color));
                p.getOutput().flush();
                p.getOutput().reset();
                iter.remove();
                if (players.size() <= 1){
                    hasWinner= true;
                }
            }
        }
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Player checkWinner(){
        if (hasWinner){
            return players.get(0);
        } else {
            return null;
        }
    }
}
