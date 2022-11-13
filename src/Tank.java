import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

/**
 * Tank objects hold the information for drawing them in the GUI and executing their gameplay in the core game loop
 */
public class Tank extends GridItem{

    public String direction;
    public Player player;
    public int armor;
    public int power;
    public String color;
    public TankType model;
    public Boolean isShooting;
    public boolean isAlive;

    enum TankType
    {
        GIGA, GOLIATH, PHOTON, EXECUTIONER
    }
    // Change tank armor by setting the value in the Tank constructor. Currently, only 1-3 armor is supported with images
    public Tank(TankType model, Point p) {
        super(p);
        imgPath = "images/tank.png";
        type = "Tank";
        direction = "North";
        this.isShooting = false;
        this.model = model;
        this.isAlive = true;

    }
    private String loadImgPath(){
        String retPath = "images/tank/" + color + "/" + direction + "/";
        switch (this.armor){
            case 3:
                retPath = retPath + "3-health.png";
                break;
            case 2:
                retPath = retPath + "2-health.png";
                break;
            case 1:
                retPath = retPath + "1-health.png";
                break;
            default:
                retPath = "images/tombstone.png";
                break;

        }
        return retPath;
    }
    public void draw(Graphics g, ImageObserver observer) {
        Image img = null;
        try {
            img = ImageIO.read(new File(loadImgPath()));
        } catch (IOException exc) {
            System.out.println("Error opening image file: " + exc.getMessage());
        }
        g.drawImage(
                img,
                pos.x * xTankGUI.TILE_SIZE,
                pos.y * xTankGUI.TILE_SIZE,
                observer
        );
        if (this.isShooting){
            try {
                String explosionPath = "images/explosion/" + direction + ".png";
                img = ImageIO.read(new File(explosionPath));
            } catch (IOException exc) {
                System.out.println("Error opening image file: " + exc.getMessage());
            }
            g.drawImage(
                    img,
                    pos.x * xTankGUI.TILE_SIZE,
                    pos.y * xTankGUI.TILE_SIZE,
                    observer
            );
        }
        this.isShooting = false;
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

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
    public void shoot(Grid grid){
        int i = 1;
        if (direction.equals("North")){

            while (grid.getItem(pos.x, pos.y-i) == null){
                i++;
            }
            Point target = new Point(pos.x, pos.y-i);
            // When/If we remove this sysout statement, we have to still call .shot() on
            // the object because right now that is how tanks lose armor
            System.out.println("This type got shot: " + grid.getItem(pos.x, pos.y-i).shot(this.power)
                                + " @Point: " + target);

        } else if (direction.equals("East")) {

            while (grid.getItem(pos.x+i, pos.y) == null){
                i++;
            }
            Point target = new Point(pos.x+i, pos.y);
            System.out.println("This type got shot: " + grid.getItem(pos.x+i, pos.y).shot(this.power)
                    + " @Point: " + target);

        } else if (direction.equals("West")) {

            while (grid.getItem(pos.x-i, pos.y) == null){
                i++;
            }
            Point target = new Point(pos.x-i, pos.y);
            System.out.println("This type got shot: " + grid.getItem(pos.x-i, pos.y).shot(this.power)
                    + " @Point: " + target);

        } else if (direction.equals("South")) {

            while (grid.getItem(pos.x, pos.y+i) == null){
                i++;
            }
            Point target = new Point(pos.x, pos.y+i);
            System.out.println("This type got shot: " + grid.getItem(pos.x, pos.y+i).shot(this.power)
                    + " @Point: " + target);
        }
        this.isShooting = true;
    }
    public synchronized void move(Grid grid, String path){
        this.isShooting = false;
        this.direction = path;
        if (path.equals("North")){
            if (pos.y > 0 && grid.getItem(pos.x, (pos.y-1)) == null){
                grid.swap(pos.x, pos.y, pos.x, pos.y-1);
            }
        } else if (path.equals("East")) {
            if (pos.x < xTankGUI.COLUMNS - 1 && grid.getItem(pos.x+1, pos.y) == null){
                grid.swap(pos.x, pos.y, pos.x+1, pos.y);
            }
        } else if (path.equals("West")) {
            if (pos.x > 0 && grid.getItem(pos.x-1, pos.y) == null){
                grid.swap(pos.x, pos.y, pos.x-1, pos.y);
            }
        } else if (path.equals("South")) {
            if (pos.y < xTankGUI.ROWS - 1 && grid.getItem(pos.x, pos.y+1) == null){
                grid.swap(pos.x, pos.y, pos.x, pos.y+1);
            }
        }

        System.out.println(pos);
    }
    public String shot(int power){
        this.armor = armor-power;
        return type;
    }
    public boolean isDead(){
        return armor <= 0;
    }

    public synchronized void despawn(Grid grid){
        grid.setItem(pos.x, pos.y, null);
    }

    public TankType getModel() {
        return model;
    }

    public void setModel(TankType model) {
        this.model = model;
    }


}
