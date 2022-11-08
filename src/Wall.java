import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Wall extends GridItem{

    public Wall(Point p) {
        super(p);
    }
    private void loadImage() {
        try {
            img = ImageIO.read(new File("images/wall.png"));
        } catch (IOException exc) {
            System.out.println("Error opening image file: " + exc.getMessage());
        }
    }
}