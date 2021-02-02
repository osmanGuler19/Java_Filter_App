
package filterapp;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.math.RoundingMode;
import static javafx.scene.paint.Color.rgb;


public class Filterapp {

  
    public static void main(String[] args) 
    {
        BufferedImage img = null;
        try
        {
            
            img = ImageIO.read(new File("image.jpeg"));
            
        } 
        catch (IOException e)
        {
            System.out.println("Dosya bulunamadı. Lütfen daha sonra tekrar deneyiniz");
        }
        if(img==null)
        {
            System.out.println("");
        }
        
        else
        {
            int width = img.getWidth();
            int height = img.getHeight();
            
            int a = img.getRGB(1, 2);
            
            
            
            
            for(int i = 0; i<height;i++)
            {
                for(int j = 0; j<width;j++)
                {
                    Color color = new Color(img.getRGB(j,i));
                    int blue = color.getBlue();
                    int red = color.getRed();
                    int green = color.getGreen();
                    int alpha = color.getAlpha();
                    
                    int yuzde =Math.round((blue/85)*100);
                    int newBlue = blue + (yuzde);
                    if(newBlue>255)
                    {
                        newBlue = 250;
                    }
                    
                    
                    int p = (alpha<<24) | (red<<16) | (green<<8) | newBlue;
                    
                    img.setRGB(j,i,p);
                }
            }
            
            File f = null;
            try
            {
                f = new File("C:/Users/osman/Documents/NetBeansProjects/filterapp/Newimage.jpg");
                ImageIO.write(img, "jpg", f);
            }
            catch (IOException e)
            {
                System.out.println("Bir hata meydana geldi");
            }
            System.out.println("operation done!!");
            
        
            /*
            int getRGB[] = img.getRGB(0, 0, width, height, null, 0, width);
            
            for(int k =0;k<=getRGB.length;k++)
            {
                System.out.println(getRGB[k]);
            }
            */
        
            /*
            for(int i = 0; i<=height;i++)
            {
                for(int j = 0; j<=width;j++)
                {
                
                }
            }
            */
        }
        
        
          
    }
    
}
