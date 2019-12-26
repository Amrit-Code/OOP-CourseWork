import java.util.*;
import java.awt.image.*;
public class Warrior extends Character
{
    private final static int[] baseStats = {2,125,25};
    public Warrior(int level){
        super(baseStats[0] + (1 * level), baseStats[1] + (15 * level), baseStats[2] + (5 * level), level);
        setAnimation();
        setName("Warrior");
    }
    public Warrior(){ 
        super(baseStats[0], baseStats[1], baseStats[2], 1);
        setAnimation();
        setName("Warrior");
    } 
    private void setAnimation(){
        SpriteSheet spriteSheet = new SpriteSheet(SpriteSheet.setSpriteSheet("Worrior"));

        ArrayList<BufferedImage> standingFrames = new ArrayList<BufferedImage>();
        standingFrames.add(spriteSheet.grabImage(357,49,180,200));
        standingFrames.add(spriteSheet.grabImage(537,49,180,200));
        setStandingAnimation(standingFrames);
        
        BufferedImage damageFrame = spriteSheet.grabImage(1143,56,150,190);
        setDamageAnimationFrame(damageFrame);
        
        ArrayList<BufferedImage> fightingFrames = new ArrayList<BufferedImage>();
        fightingFrames.add(spriteSheet.grabImage(0,505,160,190));
        fightingFrames.add(spriteSheet.grabImage(163,494,190,200));
        fightingFrames.add(spriteSheet.grabImage(357,495,180,200));
        fightingFrames.add(spriteSheet.grabImage(556,534,180,160));
        setAttackAnimationFrames(fightingFrames);
    }
}
