import java.awt.event.KeyEvent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Player {
    public Tank tank;
    public boolean isDead;
    ObjectInputStream input;
    ObjectOutputStream output;

    public Player(ObjectInputStream in, ObjectOutputStream out){
        isDead = false;
        input = in;
        output = out;


    }
    // I dont know if this is the right place for this method.
    // However I think we can cut and paste it out when we find the right place.
    public void keyPressed(KeyEvent e, Grid g) {

        int key = e.getKeyCode();

        // depending on which arrow key was pressed, we're going to move the player by
        // one whole tile for this input
        if (key == KeyEvent.VK_UP) {
            tank.move(g, "North");
        }
        if (key == KeyEvent.VK_RIGHT) {
            tank.move(g, "East");
        }
        if (key == KeyEvent.VK_DOWN) {
            tank.move(g, "South");
        }
        if (key == KeyEvent.VK_LEFT) {
            tank.move(g, "West");
        }
        if (key == KeyEvent.VK_SPACE) {
            tank.shoot(g);
        }
    }

    public ObjectInputStream getInput() {
        return input;
    }

    public void setInput(ObjectInputStream input) {
        this.input = input;
    }

    public ObjectOutputStream getOutput() {
        return output;
    }

    public Tank getTank() {
        return tank;
    }

    public void setTank(Tank tank) {
        this.tank = tank;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public void setOutput(ObjectOutputStream output) {
        this.output = output;
    }
}
