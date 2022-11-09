import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Wall extends GridItem{

    public Wall(Point p) {
        super(p);
        imgPath = "images/wall.png";
        type = "Wall";
    }

}