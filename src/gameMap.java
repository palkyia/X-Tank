import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class gameMap extends JPanel implements KeyListener, ActionListener {
    public static final int TILE_SIZE = 50;
    public static final int ROWS = 15;
    public static final int COLUMNS = 20;

    public Grid grid;
    private ObjectOutputStream output;

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid newGrid) {
        this.grid = newGrid;
        repaint();
    }

    public gameMap(ObjectOutputStream out){
        setPreferredSize(new Dimension(TILE_SIZE * COLUMNS, TILE_SIZE * ROWS));
        setBackground(Color.lightGray);
        this.grid = new GridA();
        this.output = out;
        Timer timer = new Timer(0, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        drawBackground(g);
        drawGrid(g);
    }
    private void drawBackground(Graphics g){
        g.setColor(new Color(214, 214, 214));
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                // only color every other tile
                if ((row + col) % 2 == 1) {
                    g.fillRect(
                            col * TILE_SIZE,
                            row * TILE_SIZE,
                            TILE_SIZE,
                            TILE_SIZE
                    );
                }
            }
        }
    }
    private void drawGrid(Graphics g){
        grid.draw(g, this);
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        // depending on which arrow key was pressed, we're going to move the player by
        // one whole tile for this input
        if (key == KeyEvent.VK_UP) {
            try {
                output.writeObject(new clientMessage(xTankServer.commands.NORTH));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (key == KeyEvent.VK_RIGHT) {
            try {
                output.writeObject(new clientMessage(xTankServer.commands.EAST));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (key == KeyEvent.VK_DOWN) {
            try {
                output.writeObject(new clientMessage(xTankServer.commands.SOUTH));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (key == KeyEvent.VK_LEFT) {
            try {
                output.writeObject(new clientMessage(xTankServer.commands.WEST));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (key == KeyEvent.VK_SPACE) {
            try {
                output.writeObject(new clientMessage(xTankServer.commands.SHOOT));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        System.out.println(this.grid);
    }



    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
