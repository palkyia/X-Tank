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

}
