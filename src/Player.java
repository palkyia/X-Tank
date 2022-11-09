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
