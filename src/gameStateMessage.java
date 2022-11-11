import java.io.Serializable;

public class gameStateMessage implements Serializable {
    Grid grid;
    boolean isAlive;
    boolean isWinner;
    String playerColor;

    public gameStateMessage(Grid gameGrid, boolean alive, boolean isWinner, String color){
        this.grid = gameGrid;
        this.isAlive = alive;
        this.isWinner = isWinner;
        this.playerColor = color;
    }

    public Grid getGrid() {
        return grid;
    }


}
