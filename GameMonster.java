import java.util.ArrayList;
import java.util.LinkedList;
import java.awt.Graphics; 
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.image.BufferedImage;
public class GameMonster extends GameObject
{
    private float width = 32, height = 64;
    private float gravity = 0.5f;
    private final float MAX_SPEED = 10;
    private int health;
    private boolean dead = false;
    private Handler handler;
    private Character character;
    private ArrayList<BufferedImage> standingAnimation;
    public GameMonster(float x, float y,Handler handler, ObjectId id, String level){
        super(x, y, id);
        this.handler = handler;
        int levelNo = getLevelNo(level);
        Monster monster = new Monster(levelNo);
        character = (Character) monster;
        standingAnimation = character.getStandingAnimation();
        health = character.getHealth();
    }
    public void tick(LinkedList<GameObject> object){
        x+= velX;
        y+= velY;
        
        if(falling || jumping){
            velY += gravity;
            if(velY > MAX_SPEED){
                velY= MAX_SPEED;
            }
        }
        if(dead){
            handler.removeObject(this);
            handler.removeMonster(this);
        }
        Collision(object);
        movment(object);
    }
    public void render(Graphics g){
        g.drawImage(standingAnimation.get(0), (int)x, (int)y,32, 64, null);
        Graphics2D g2d = (Graphics2D) g;
    }
    private void Collision(LinkedList<GameObject> object){
        for(int i = 0; i < handler.object.size(); i ++){
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getId() == ObjectId.Block){
                if(getBoundsTop().intersects(tempObject.getBounds())){
                    y = tempObject.getY() + 35;
                    velY=0;
                }
                if(getBounds().intersects(tempObject.getBounds())){
                    y = tempObject.getY() - (height + 3);
                    velY=0;
                    falling = false;
                    jumping = false;
                }else{
                    falling = true;
                }
                if(getBoundsRight().intersects(tempObject.getBounds())){
                    x = tempObject.getX() - (width +3);
                    jumping = true;
                    velY = -10;
                }
                if(getBoundsLeft().intersects(tempObject.getBounds())){
                    x = tempObject.getX() + (width +3);
                    jumping = true;
                    velY = -10;
                }
            }else if(tempObject.getId() == ObjectId.Bullet){
                if(getBoundsTop().intersects(tempObject.getBounds())
                ||getBounds().intersects(tempObject.getBounds())
                ||getBoundsRight().intersects(tempObject.getBounds())
                ||getBoundsLeft().intersects(tempObject.getBounds())){
                    health -= tempObject.getDamage();
                    if(health <= 0){
                        x = 10000;
                        dead = true;
                    }
                }
            }else if(tempObject.getId() == ObjectId.GameMonster){
                for(int n = 0; n < handler.monster.size(); n ++){
                    GameMonster tempObject1 = handler.monster.get(n);
                    if(getBoundsLeft().intersects(tempObject1.getBoundsRight()) 
                    || getBoundsLeft().intersects(tempObject1.getBoundsLeft())){
                        x = tempObject1.getX() - width;
                    }
                    if(getBoundsRight().intersects(tempObject1.getBoundsLeft())
                    || getBoundsRight().intersects(tempObject1.getBoundsRight())){
                        x = tempObject1.getX() + width;
                    }
                    if(getBounds().intersects(tempObject1.getBoundsTop())){
                        x = tempObject.getX() + (width +3);
                        jumping = true;
                        velY = -10;
                    }
                    if(getBoundsTop().intersects(tempObject1.getBounds())){
                        jumping = false;
                        if(velY > 0){
                            velY = 0;
                        }
                        
                    }
                }
            }
        }
    }
    public Rectangle getBounds(){
        return new Rectangle((int)((int)x +(width/2)-((width/2)/2)),(int)((int)y+(height/2)),(int)width/2,(int)height/2);
    }
    public Rectangle getBoundsTop(){
        return new Rectangle((int)((int)x +(width/2)-((width/2)/2)), (int)y,(int)width/2,(int)height/2);
    }
    public Rectangle getBoundsRight(){
        return new Rectangle((int)(x+width-5), (int)y+5,(int)5,(int)height-10);
    }
    public Rectangle getBoundsLeft(){
        return new Rectangle((int)x, (int)y+5,(int)5,(int)height-10);
    }
    public int getLevelNo(String level){
        String[] values = level.split(" ");
        return Integer.parseInt(values[1]);
    }
    public void movment(LinkedList<GameObject> object){
        for(int i = 0; i < handler.object.size(); i ++){
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getId() == ObjectId.Player){
                if((x - tempObject.getX()) > 0){
                    velX = -3;
                }else{
                    velX = 3;
                }
            }
        }
    }
}
