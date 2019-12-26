import java.util.LinkedList;
import java.awt.Graphics; 
import java.awt.Rectangle;
import java.awt.Color;
public class Flag extends GameObject
{
    public Flag(float x, float y, ObjectId id){
        super(x, y, id);
    }
    public void tick(LinkedList<GameObject> object){
        
    }
    public void render(Graphics g){
        BufferedImageLoader loader = new BufferedImageLoader();
        g.drawImage(loader.loadImage("flag.png"), (int)x, (int)y,32, 64, null);
    }
    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 32, 64);
    }
}
