import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Wall extends GridItem{

    public Wall(Point p) {
        super(p);
        loadImage();
        type = "Wall";
    }
    private void loadImage() {
        try {
            this.img = ImageIO.read(new File("images/wall.png"));
        } catch (IOException exc) {
            System.out.println("Error opening image file: " + exc.getMessage());
        }
    }
}