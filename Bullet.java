import java.util.ArrayList;
import java.util.LinkedList;
import java.awt.Graphics; 
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.image.BufferedImage;
public class Bullet extends GameObject
{
    private boolean dead = false;
    private Handler handler;
    public Bullet(float x, float y,Handler handler, ObjectId id, int speed, int damage){
        super(x, y, id);
        this.handler = handler;
        setDamage(damage);
        velX = speed;
    }
    public void tick(LinkedList<GameObject> object){
        x+= velX;
        y+= velY;
        
        if(dead){
            handler.removeObject(this);
        }
        Collision(object);
    }
    public void render(Graphics g){
        g.setColor(Color.red);
        g.fillRect((int)x,(int)y,16,16);
    }
    private void Collision(LinkedList<GameObject> object){
        int initialSize = handler.object.size();
        for(int i = 0; i < handler.object.size(); i ++){
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getId() == ObjectId.Block){
                if(getBounds().intersects(tempObject.getBounds())){
                    x = 10000;
                    dead = true;
                }
            }else if(tempObject.getId() == ObjectId.GameMonster){
                if(getBounds().intersects(tempObject.getBounds())){
                    x = 10000;
                    dead = true;
                }
            }else if(handler.object.size() != initialSize){
                x = 10000;
                dead = true;
            }
        }
    }
    public Rectangle getBounds(){
        return new Rectangle((int)x,(int)y,16,16);
    }
}
