import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

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
        Tank tank = createTank();
        grid.setItem(tank.pos.x, tank.pos.y, tank);
        player.setTank(tank);
        players.add(player);

    }
    private Tank createTank(){
        String color = null;
        Point point = null;
        Random random = new Random();
        boolean generatingSpawn= true;
        while (generatingSpawn){
            int rand_x = random.nextInt(gameMap.COLUMNS);
            int rand_y = random.nextInt(gameMap.ROWS);
            if (grid.getItem(rand_x, rand_y) == null){
                point = new Point(rand_x, rand_y);
                generatingSpawn = false;
            }
        }
        switch (players.size()) {
            case 0 -> {
                System.out.println("Player 1 created.");
                color = "green";
            }
            case 1 -> {
                System.out.println("Player 2 created.");
                color = "tan";
            }
            case 2 -> {
                System.out.println("Player 3 created.");
                color = "yellow";
            }
            case 3 -> {
                System.out.println("Player 4 created.");
                color = "purple";
            }
            default -> color = "green";
        }
        return new Tank(point, color);
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
