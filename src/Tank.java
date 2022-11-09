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
        loadImage();
        type = "Tank";
    }
    public void shoot(Grid grid){

    }
    public void move(Grid grid){

    }
    public String shot(){
        health--;
        return type;
    }
    private void loadImage(){
        try {
            img = ImageIO.read(new File("images/tank.png"));
        } catch (IOException exc) {
            System.out.println("Error opening image file: " + exc.getMessage());
        }
    }

}
