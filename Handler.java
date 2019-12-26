import java.util.LinkedList;
import java.awt.Graphics;
public class Handler 
{
    public LinkedList<GameObject> object = new LinkedList<GameObject>();
    public LinkedList<GameMonster> monster = new LinkedList<GameMonster>();
    
    private GameObject tempObject;
    
    public void tick(){
        for(int i = 0; i < object.size(); i ++){
            tempObject = object.get(i);
            tempObject.tick(object);
        }
    }
    public void render(Graphics g){
        for(int i = 0; i < object.size(); i ++){
            tempObject = object.get(i);
            tempObject.render(g);
        }
    }
    
    public void addObject(GameObject object){
        this.object.add(object);
    }
    public void removeObject(GameObject object){
        this.object.remove(object);
    }
    public void addMonster(GameMonster monster){
        this.monster.add(monster);
    }
    public void removeMonster(GameMonster monster){
        this.monster.remove(monster);
    }
    
}
