import java.awt.Color;
public class Pixel
{
    private BasicPicture myPic;
    private int x;
    private int y;

    public Pixel(BasicPicture myPic, int x, int y)
    {
        this.myPic = myPic;
        this.x = x;
        this.y = y;
    }

    public Color getColor() 
    { 
        int value = myPic.getImage().getRGB(x,y);
        int red = (value >> 16) & 0xff;
        int green = (value >>  8) & 0xff;
        int blue = value & 0xff;
        return new Color(red,green,blue);
    }
    
    public int getRgb()
    {
        return myPic.getImage().getRGB(x,y);
    }
}
