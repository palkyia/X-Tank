import java.awt.*;
import java.awt.image.ImageObserver;

public class GridItem {

    public Point pos;
    public Image img;
    public String type;

    public GridItem(Point p){
        this.pos = p;
    }
    public String shot(){
        return this.type;
    }
    private void loadImage() {
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
