import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class GridItem {

    public Point pos;
    public Image img;

    public GridItem(Point p){
        this.pos = p;
        loadImage();
    }
    public void shot(){
    }
    private void loadImage() {
        try {
            img = ImageIO.read(new File("images/blank.png"));
        } catch (IOException exc) {
            System.out.println("Error opening image file: " + exc.getMessage());
        }
    }
    public void draw(Graphics g, ImageObserver observer){
        // The 50 represents the tile length and width
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

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }
}
