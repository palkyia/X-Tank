import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Extends Grid to define a concrete map.
 */
public class GridA extends Grid implements Serializable {
    public ArrayList<ArrayList<GridItem>> grid;
    private String [][] startConfig =
            {       // default map, change this 2D array to alter the map and create your own.
                    // W = Wall
                    // N = Empty space for movement
                    {"W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W"},
                    {"W","N","N","N","N","N","N","N","N","W","N","N","N","N","N","N","N","N","N","W"},
                    {"W","N","N","N","N","N","N","N","N","W","N","N","N","N","N","N","N","N","N","W"},
                    {"W","N","N","N","N","N","N","N","N","N","N","N","N","N","N","N","N","N","N","W"},
                    {"W","N","N","N","N","N","N","N","N","N","N","N","N","N","N","N","N","N","N","W"},
                    {"W","N","N","N","N","N","N","N","N","N","N","N","N","N","N","N","N","N","N","W"},
                    {"W","N","N","N","N","N","N","N","W","W","N","N","N","N","N","N","N","N","N","W"},
                    {"W","W","W","N","N","N","W","N","W","W","W","W","N","N","N","N","N","W","W","W"},
                    {"W","N","N","N","N","N","N","N","N","N","N","N","N","N","N","N","N","N","N","W"},
                    {"W","N","N","N","N","N","N","N","N","N","N","N","N","N","N","N","N","N","N","W"},
                    {"W","N","N","N","N","N","N","N","N","N","N","N","N","N","N","N","N","N","N","W"},
                    {"W","N","N","N","N","N","N","N","N","N","N","N","N","N","N","N","N","N","N","W"},
                    {"W","N","N","N","N","N","N","N","N","W","N","N","N","N","N","N","N","N","N","W"},
                    {"W","N","N","N","N","N","N","N","N","W","N","N","N","N","N","N","N","N","N","W"},
                    {"W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W"}
            };

    public GridA(){
        build();
    }
    public void swap(int x1, int y1, int x2, int y2){
        GridItem temp1 = grid.get(y1).get(x1);
        GridItem temp2 = grid.get(y2).get(x2);
        grid.get(y1).set(x1, temp2);
        grid.get(y2).set(x2, temp1);
        if (grid.get(y1).get(x1) != null){
            grid.get(y1).get(x1).setPos(new Point(x1, y1));
        }
        if (grid.get(y2).get(x2) != null){
            grid.get(y2).get(x2).setPos(new Point(x2, y2));
        }



    }
    public GridItem getItem(int x1, int y1){
        return grid.get(y1).get(x1);
    }
    public GridItem setItem(int x1, int y1, GridItem item){
        return grid.get(y1).set(x1, item);
    }
    public void build(){
        this.grid = new ArrayList<>(xTankGUI.ROWS);
        for (int row = 0; row < xTankGUI.ROWS; row++){
            ArrayList<GridItem> curRow = new ArrayList<>(xTankGUI.COLUMNS);
            for (int col = 0; col < xTankGUI.COLUMNS; col++){
                if (startConfig[row][col].equals("W")){
                    curRow.add(new Wall(new Point(col, row)));
                }
                else {
                    curRow.add(null);
                }
            }
            grid.add(curRow);
        }
    }
    public void draw(Graphics g, ImageObserver observer){
        for (int row = 0; row < xTankGUI.ROWS; row++) {
            for (int col = 0; col < xTankGUI.COLUMNS; col++) {
                if(grid.get(row).get(col) != null){
                    grid.get(row).get(col).draw(g, observer);
                }
            }
        }
    }
    @Override
    public String toString(){
       return this.grid.toString();
    }


}
