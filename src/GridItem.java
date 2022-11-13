import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

/**
 * Grid items are stored in Grid to identify what object is located at each point in the Grid.
 */
public class GridItem implements Serializable {

    public Point pos;
    public String imgPath;
    public String type;

    public GridItem(Point p){
        this.pos = p;
    }
    public String shot(int power){
        return this.type;
    }

    public void draw(Graphics g, ImageObserver observer) {
        // The 50 represents the tile length and width
        Image img = null;
        try {
            img = ImageIO.read(new File(imgPath));
        } catch (IOException exc) {
            System.out.println("Error opening image file: " + exc.getMessage());
        }
        g.drawImage(
                img,
                pos.x * 50,
                pos.y * 50,
                observer
        );
    }
    public Point getPos() {
        return pos;
    }

    public void setPos(Point pos) {
        this.pos = pos;
    }


}
