import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
public class SpriteSheet
{
    private BufferedImage image;
    public SpriteSheet(BufferedImage image){
        this.image = image;
    }
    
    public BufferedImage grabImage(int col, int row, int width, int height){
        BufferedImage img = image.getSubimage(col,row ,width,height);
        return img;
    }
    
    public static BufferedImage setSpriteSheet(String file){
        BufferedImage spriteSheet = null;
        try{
            spriteSheet = ImageIO.read(new File(file+".png"));
        }catch(Exception e){
            System.out.println("did not work1");
        }
        return spriteSheet;
    }
}
