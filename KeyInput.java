import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class KeyInput extends KeyAdapter 
{
    Handler handler;
    public KeyInput(Handler handler){
        this.handler = handler;
    }
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        
        for(int i = 0; i < handler.object.size(); i ++){
            GameObject tempObject = handler.object.get(i);
            
            if(tempObject.getId() == ObjectId.Player){
                if(key == KeyEvent.VK_D){
                    tempObject.setVelX(5);
                    tempObject.setFacing(1); 
                }
                if(key == KeyEvent.VK_A){
                    tempObject.setVelX(-5);
                    tempObject.setFacing(-1);
                }
                if(key == KeyEvent.VK_W && !tempObject.getJumping()){
                    tempObject.setJumping(true);
                    tempObject.setVelY(-10);
                }
                if(key == KeyEvent.VK_SPACE){
                    handler.addObject(new Bullet(tempObject.getX(), tempObject.getY() + 24, handler,ObjectId.Bullet,
                    (int)tempObject.getFacing() * 7, tempObject.getDamage()));   
                }
            }
        }
       
        if(key == KeyEvent.VK_ESCAPE){
            System.exit(0);
        }
    }
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        for(int i = 0; i < handler.object.size(); i ++){
            GameObject tempObject = handler.object.get(i);
            
            if(tempObject.getId() == ObjectId.Player){
                if(key == KeyEvent.VK_D){
                    tempObject.setVelX(0);
                    tempObject.setFacing(1); 
                }
                if(key == KeyEvent.VK_A){
                    tempObject.setVelX(0);
                    tempObject.setFacing(-1);
                }
                
            }
        }
    }
}
