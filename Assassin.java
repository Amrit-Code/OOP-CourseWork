import java.util.*;
import java.awt.image.*;
public class Assassin extends Character
{
    private final static int[] baseStats = {10,75,25};
    public Assassin( int level){
        super(baseStats[0] + (1 * level), baseStats[1] + (15 * level), baseStats[2] + (5 * level), level);
        setAnimations();
        setName("Assassin");
    }
    public Assassin(){ 
        super(baseStats[0], baseStats[1], baseStats[2], 1);
        setAnimations();
        setName("Assassin");
    } 
    private void setAnimations(){
        SpriteSheet spriteSheet = new SpriteSheet(SpriteSheet.setSpriteSheet("Assassin"));
        
        BufferedImage damageFrame = spriteSheet.grabImage(1670,418,160,182);
        setDamageAnimationFrame(damageFrame);
        
        BufferedImage standingImage = spriteSheet.grabImage(1,445,200,160);
        ArrayList<BufferedImage> standingFrame = new ArrayList<BufferedImage>();
        standingFrame.add(standingImage);
        setStandingAnimation(standingFrame);
        
        ArrayList<BufferedImage> attackAnimation = new ArrayList<BufferedImage>();
        attackAnimation.add(spriteSheet.grabImage(1044,439,150,170));
        attackAnimation.add(spriteSheet.grabImage(1198,443,118,165));
        setAttackAnimationFrames(attackAnimation);
    }

}
