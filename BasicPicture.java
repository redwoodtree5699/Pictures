import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import java.awt.*;
import java.io.*;
import java.awt.geom.*;

/**
 * 
 * @author Amy 
 * @version 04/02/17
 */
public class BasicPicture
{
    private BufferedImage image;
    private String fileName;
    private int width;
    private int height;
    public BasicPicture(String fileName)
    {
        load(fileName);
        picSettings();
    }
    
    public BasicPicture(BufferedImage pic)
    {
        image = pic;
        picSettings();
    }

    public void picSettings()
    {
        width = image.getWidth();
        height = image.getHeight();
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public BufferedImage getImage()
    {
        return image;
    }
    public void loadOrFail(String fileName) throws IOException
    {
        this.fileName = fileName;
        File file = new File(this.fileName);

        if (!file.canRead())
        {
            throw new IOException(this.fileName + " could not be opened.");
        }
        image = ImageIO.read(file);
    }

    public void load(String fileName)
    {
        try {
            this.loadOrFail(fileName);

        } catch (Exception ex) {
            System.out.println("There was an error trying to open " + fileName);
        }
    }

}
