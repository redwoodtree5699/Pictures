import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import java.awt.image.WritableRaster;
import java.awt.*;
import java.io.*;
import java.awt.geom.*;

public class Picture
{
    private BasicPicture myPic;
    private int myWidth;
    private int myHeight;
    private int extent;
    private Pixel[][] pixArr;

    public Picture(String fileName, int ext)
    {
        myPic = new BasicPicture(fileName);
        myWidth = myPic.getWidth();
        myHeight = myPic.getHeight();
        extent = ext;
    }

    public Pixel[][] getPixels()
    {
        pixArr = new Pixel[myWidth][myHeight];

        for (int row = 0; row < myWidth; row++)
        {
            for (int col = 0; col < myHeight; col++) 
            {
                pixArr[row][col] = new Pixel(myPic,row,col);
            }
        }
        return pixArr;
    }

    public void printPixelValueArray()
    {
        Pixel[][] pixArr = getPixels();
        for (int row = 0; row < myWidth; row++)
        { 
            for (int col = 0; col < myHeight; col++)
            {
                System.out.print(pixArr[row][col].getColor());
            }
            System.out.println();
        }
    }

    public int[][] toIntArray(Pixel[][] pixels)
    {
        int[][] arr = new int[myWidth][myHeight];
        for (int row = 0; row < myWidth; row++)
        { 
            for (int col = 0; col < myHeight; col++)
            {
                arr[row][col] = pixels[row][col].getRgb();
            }
        }
        return arr;
    }

    public int getWidth()
    {
        return myWidth;
    }

    public int getHeight()
    {
        return myHeight;
    }
}
