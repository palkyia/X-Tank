import java.io.PrintWriter;
import java.util.Scanner;

public class Player {
    public Tank tank;
    public boolean isDead;
    Scanner input;
    PrintWriter output;

    public Player(){

    }

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    public PrintWriter getOutput() {
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

    public void setOutput(PrintWriter output) {
        this.output = output;
    }
}
