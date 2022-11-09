import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.Serializable;
import java.util.ArrayList;

public class GridA extends Grid implements Serializable {
    public ArrayList<ArrayList<GridItem>> grid;
    private String [][] startConfig =
            {
                    {"W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W"},
                    {"W","T","N","N","N","N","N","N","N","W","N","N","N","N","N","N","N","N","T","W"},
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
                    {"W","T","N","N","N","N","N","N","N","W","N","N","N","N","N","N","N","N","T","W"},
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
    }
    public GridItem getItem(int x1, int y1){
        return grid.get(y1).get(x1);
    }
    public GridItem setItem(int x1, int y1, GridItem item){
        return grid.get(y1).set(x1, item);
    }
    public void build(){
        this.grid = new ArrayList<>(15);
        for (int row = 0; row < 15; row++){
            ArrayList<GridItem> curRow = new ArrayList<>(20);
            for (int col = 0; col < 20; col++){
                if (startConfig[row][col].equals("W")){
                    curRow.add(new Wall(new Point(col, row)));
                } else if (startConfig[row][col].equals("T")) {
                    curRow.add(new Tank(new Point(col, row)));
                }
                else {
                    curRow.add(null);
                }
            }
            grid.add(curRow);
        }
    }
    public void draw(Graphics g, ImageObserver observer){
        for (int row = 0; row < 15; row++) {
            for (int col = 0; col < 20; col++) {
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
