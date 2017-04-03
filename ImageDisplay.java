import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.*;
import javax.swing.border.*;

public class ImageDisplay
{
    private BasicPicture image;
    private int width;
    private int height;
    private String myPic;

    public ImageDisplay(String fileName)
    {
        image = new BasicPicture(fileName);
        myPic = fileName;
        width = image.getWidth();
        height = image.getHeight();
    }
    
    public ImageDisplay(BufferedImage pic)
    {
        image = new BasicPicture(pic);
    }

    public BufferedImage getBImage()
    {
        return image.getImage();
    }

    public void display()
    {
        JFrame window = new JFrame();
        window.setPreferredSize(new Dimension(width, height));
        JPanel board = new JPanel();
        board.add(new JLabel(new ImageIcon(myPic)));
        window.getContentPane().add(board);
        window.pack();
        window.setVisible(true);
        window.addWindowListener(new WindowAdapter() 
            {
                public void windowClosing(WindowEvent windowEvent)
                {
                    System.exit(0);
                }        
            });
    }

}
