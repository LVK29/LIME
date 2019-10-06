
import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;


/**
 *
 * @author kaushal420
 */
public class ReadImageToMark 
{
   public static void main(String args[])
   {
        File sourceImageFile = new File("D:/images//bharat.PNG");
        File watermarkImageFile = new File("D:/images//amc_logo.png");
        File destImageFile = new File("D:/images//watermark_pic.png");
 
        addImageWatermark(watermarkImageFile, sourceImageFile, destImageFile);
   }
   
   static void addImageWatermark(File watermarkImageFile, File sourceImageFile, File destImageFile) {
    try {
        BufferedImage sourceImage = ImageIO.read(sourceImageFile);
        BufferedImage watermarkImage = ImageIO.read(watermarkImageFile);
        // initializes necessary graphic properties
        Graphics2D g2d = (Graphics2D) sourceImage.getGraphics();
        AlphaComposite alphaChannel = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f);
        g2d.setComposite(alphaChannel);
        // calculates the coordinate where the image is painted
        int topLeftX = (sourceImage.getWidth() - watermarkImage.getWidth()) / 2;
        int topLeftY = (sourceImage.getHeight() - watermarkImage.getHeight()) / 2;
        // paints the image watermark
        g2d.drawImage(watermarkImage, topLeftX, topLeftY, null);
        ImageIO.write(sourceImage, "png", destImageFile);
        g2d.dispose();
 
        System.out.println("The image watermark is added to the image.");
 
    } catch (Exception ex) {
        System.err.println(ex);
    }
}
}
