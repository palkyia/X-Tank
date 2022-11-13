import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Walls are the GridItems used to shape the map, blocking movement and tank shots.
 */
public class Wall extends GridItem{

    public Wall(Point p) {
        super(p);
        imgPath = "images/wall.png";
        type = "Wall";
    }

}