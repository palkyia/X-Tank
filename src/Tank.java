import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Tank extends GridItem{

    public String direction;
    public Player player;
    public int health;
    public int power;

    public Tank(Point p) {
        super(p);
        imgPath = "images/tank.png";
        type = "Tank";
        direction = "North";
    }
    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
    // Some logic in the shoot() and move() methods may need
    // to be moved to another area.
    public void shoot(Grid grid){
        int i = 1;
        if (direction.equals("North")){

            while (grid.getItem(pos.x, pos.y+i) == null){
                i++;
            }
            Point target = new Point(pos.x, pos.y+i);
            // When/If we remove this sysout statement, we have to still call .shot() on
            // the object because right now that is how tanks lose health
            System.out.println("This type got shot: " + grid.getItem(pos.x, pos.y+i).shot()
                                + " @Point: " + target);

        } else if (direction.equals("East")) {

            while (grid.getItem(pos.x+i, pos.y) == null){
                i++;
            }
            Point target = new Point(pos.x+i, pos.y);
            System.out.println("This type got shot: " + grid.getItem(pos.x+i, pos.y).shot()
                    + " @Point: " + target);

        } else if (direction.equals("West")) {

            while (grid.getItem(pos.x-i, pos.y) == null){
                i++;
            }
            Point target = new Point(pos.x-i, pos.y);
            System.out.println("This type got shot: " + grid.getItem(pos.x-i, pos.y).shot()
                    + " @Point: " + target);

        } else if (direction.equals("South")) {

            while (grid.getItem(pos.x, pos.y-i) == null){
                i++;
            }
            Point target = new Point(pos.x, pos.y-i);
            System.out.println("This type got shot: " + grid.getItem(pos.x, pos.y-i).shot()
                    + " @Point: " + target);
        }
    }
    public void move(Grid grid, String path){
        this.direction = path;
        if (path.equals("North")){
            if (grid.getItem(pos.x, (pos.y-1)) == null){
                grid.swap(pos.x, pos.y, pos.x, pos.y-1);
            }
        } else if (path.equals("East")) {
            if (grid.getItem(pos.x+1, pos.y) == null){
                grid.swap(pos.x, pos.y, pos.x+1, pos.y);
            }
        } else if (path.equals("West")) {
            if (grid.getItem(pos.x-1, pos.y) == null){
                grid.swap(pos.x, pos.y, pos.x-1, pos.y);
            }
        } else if (path.equals("South")) {
            if (grid.getItem(pos.x, pos.y+1) == null){
                grid.swap(pos.x, pos.y, pos.x, pos.y+1);
            }
        }
    }
    public String shot(){
        health--;
        return type;
    }


}
