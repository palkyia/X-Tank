import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

public class Grid {

    public ArrayList<ArrayList<GridItem>> grid;

    public Grid(){
        build();
    }
    public void swap(int x1, int y1, int x2, int y2){

    }
    public GridItem getItem(int x1, int y1){
        return grid.get(y1).get(x1);
    }
    public GridItem setItem(int x1, int y1, GridItem item){
        return grid.get(y1).set(x1, item);
    }
    private void build(){

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
}
