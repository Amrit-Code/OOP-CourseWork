import java.util.*;
import java.awt.image.*;
public class Mage extends Character
{
    public final static int[] baseStats = {5,100,20};
    public Mage( int level){
        super(baseStats[0] + (1 * level), baseStats[1] + (15 * level), baseStats[2] + (5 * level), level);
        setAnimation();
        setName("Mage");
    }
    public Mage(){
        super(baseStats[0], baseStats[1], baseStats[2], 1);
        setAnimation();
        setName("Mage");
    }
    private void setAnimation(){
        SpriteSheet spriteSheet = new SpriteSheet(SpriteSheet.setSpriteSheet("Mage"));
        
        ArrayList<BufferedImage> standingFrames = new ArrayList<BufferedImage>();
        standingFrames.add(spriteSheet.grabImage(797,281,251,223));
        standingFrames.add(spriteSheet.grabImage(1047,287,244,215));
        standingFrames.add(spriteSheet.grabImage(1286,279,278,222));
        setStandingAnimation(standingFrames);
        
        BufferedImage damageFrame = spriteSheet.grabImage(0,336,159,179);
        setDamageAnimationFrame(damageFrame);
        
        ArrayList<BufferedImage> fightingFrames = new ArrayList<BufferedImage>();
        fightingFrames.add(spriteSheet.grabImage(196,582,252,187));
        fightingFrames.add(spriteSheet.grabImage(446,576,230,180));
        fightingFrames.add(spriteSheet.grabImage(670,554,220,180));
        setAttackAnimationFrames(fightingFrames);
    }
}
