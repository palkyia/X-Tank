import java.io.Serializable;

public class gameStateMessage implements Serializable {
    Grid grid;
    boolean isAlive;

    public gameStateMessage(Grid gameGrid, boolean alive){
        this.grid = gameGrid;
        this. isAlive = alive;
    }

    public Grid getGrid() {
        return grid;
    }


}
