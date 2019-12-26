import java.awt.image.BufferedImage;
import javax.imageio.ImageIO; 
import java.io.File;
public class BufferedImageLoader
{
    private BufferedImage image;
    
    public BufferedImage loadImage(String path){
        try{
            image = ImageIO.read(new File(path));
        }catch(Exception e){
            System.out.println(e);
        }
        return image;
    }
}
