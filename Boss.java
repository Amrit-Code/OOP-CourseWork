import java.util.*;
import java.awt.image.*;
public class Boss extends Character
{
    private final static int[] baseStats = {1,200,30};
    public Boss(int level){
        super(baseStats[0] + (1 * level), baseStats[1] + (15 * level), baseStats[2] + (5 * level), level);
        setAnimation();
        setName("Boss");
    }
    public Boss(){ 
        super(baseStats[0], baseStats[1], baseStats[2], 1);
        setAnimation();
        setName("Boss");
    }
    private void setAnimation(){
        SpriteSheet spriteSheet = new SpriteSheet(SpriteSheet.setSpriteSheet("Boss"));
        
        ArrayList<BufferedImage> standingFrames = new ArrayList<BufferedImage>();
        standingFrames.add(spriteSheet.grabImage(1438,1,275,267));
        standingFrames.add(spriteSheet.grabImage(1713,1,224,254));
        standingFrames.add(spriteSheet.grabImage(1935,1,180,261));
        standingFrames.add(spriteSheet.grabImage(2117,1,202,280));
        setStandingAnimation(standingFrames);
        
        BufferedImage damageFrame = spriteSheet.grabImage(2746,1,268,265);
        setDamageAnimationFrame(damageFrame);
        
        ArrayList<BufferedImage> fightingFrames = new ArrayList<BufferedImage>();
        fightingFrames.add(spriteSheet.grabImage(1623,608,273,185));
        fightingFrames.add(spriteSheet.grabImage(1896,606,263,187));
        fightingFrames.add(spriteSheet.grabImage(2159,606,274,193));
        fightingFrames.add(spriteSheet.grabImage(2433,606,264,202));
        setAttackAnimationFrames(fightingFrames);
    }
}
