import java.util.*;
import java.awt.image.*;
public class Monster extends Character
{
    private final static int[] baseStats = {5,100,20};
    public Monster(int level){
        super(baseStats[0] + (1 * level), baseStats[1] + (15 * level), baseStats[2] + (5 * level), level);
        setAnimation();
        setName("Monster");
    }
    public Monster(){ 
        super(baseStats[0], baseStats[1], baseStats[2], 1);
        setAnimation();
        setName("Monster");
    }
    private void setAnimation(){
        SpriteSheet spriteSheet = new SpriteSheet(SpriteSheet.setSpriteSheet("Monster"));
        
        ArrayList<BufferedImage> standingFrames = new ArrayList<BufferedImage>();
        standingFrames.add(spriteSheet.grabImage(242,282,101,82));
        standingFrames.add(spriteSheet.grabImage(261,281,95,85));
        standingFrames.add(spriteSheet.grabImage(468,282,100,80));
        setStandingAnimation(standingFrames);
        
        BufferedImage damageFrame = spriteSheet.grabImage(721,137,90,100);
        setDamageAnimationFrame(damageFrame);
        
        ArrayList<BufferedImage> fightingFrames = new ArrayList<BufferedImage>();
        fightingFrames.add(spriteSheet.grabImage(262,1,88,126));
        fightingFrames.add(spriteSheet.grabImage(350,1,88,126));
        fightingFrames.add(spriteSheet.grabImage(438,1,88,126));
        fightingFrames.add(spriteSheet.grabImage(526,1,88,126));
        fightingFrames.add(spriteSheet.grabImage(614,1,88,126));
        fightingFrames.add(spriteSheet.grabImage(702,1,88,126));
        fightingFrames.add(spriteSheet.grabImage(790,1,88,126));
        setAttackAnimationFrames(fightingFrames);
    }
}
