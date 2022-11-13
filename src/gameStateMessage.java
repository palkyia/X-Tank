import java.io.Serializable;

/**
 * The message object sent from the server to the player. This informs the client of the official game state to draw and
 * display to the user.
 */
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
