import java.util.*;
import java.awt.image.*;
public class Character
{
    private String name;
    private int agility; 
    private int health;
    private int damage;
    private int level;
    private int exp;
    private int reqEXP;
    private ArrayList<BufferedImage> standingAnimationFrames;
    private BufferedImage damageFrame; 
    private ArrayList<BufferedImage> attackAnimationFrames;
    
    public Character(int agility, int health, int damage, int level){
        this.agility = agility;
        this.health = health;
        this.damage = damage;
        this.level = level;
        exp = 0;
        reqEXP = 100 + (50 * level);
    }
    
    public void setAgility(int agility){
        this.agility = agility;
    }
    public void setHealth(int health){
        this.health = health;
    }
    public void setDamage(int damage){
        this.damage = damage;
    }
    public void setStandingAnimation(ArrayList<BufferedImage> standingAnimationFrames){
    this.standingAnimationFrames = standingAnimationFrames;
    }
    public void setDamageAnimationFrame(BufferedImage damageFrame){
    this.damageFrame = damageFrame;
    }
    public void setAttackAnimationFrames(ArrayList<BufferedImage> attackAnimationFrames){
    this.attackAnimationFrames = attackAnimationFrames;
    }
    public void setName(String name){
        this.name = name;
    }
    public ArrayList<BufferedImage> getStandingAnimation(){
        return standingAnimationFrames;
    }
    public BufferedImage getDamageFrame(){
        return damageFrame;
    }
    public ArrayList<BufferedImage> getAttackeAnimation(){
        return attackAnimationFrames;
    }
    public int getAgility(){
        return agility;
    }
    public int getHealth(){
        return health;
    }
    public int getDamage(){
        return damage;
    }
    public int getLevel(){
        return level;
    }
    public String getName(){
        return name;
    }
    public void expEarned(int exp){
        this.exp += exp;
        if(this.exp >= reqEXP){
            levelUp();
            exp = exp - reqEXP;
            reqEXP += 50;
        }
    } 
    public void levelUp(){
        level += 1;
        agility += 1;
        health += 15;
        damage += 5;
    }
    public static int[] getValues(int level, int[] stats){
        stats[0] += 1 * level;
        stats[1] += 15 * level;
        stats[2] += 3 * level;
        return stats;
    }
}
