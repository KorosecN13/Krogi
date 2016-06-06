import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;



import javax.imageio.ImageIO;

public class Shrani extends JPanel{
	static int a = 1;
	
    public static void shrani(BufferedImage img) throws IOException{
        ImageIO.write(img, "PNG", new File("filename" + a + ".png"));
        a += 1;
    }

    public void load() throws IOException {
        BufferedImage paintImage = ImageIO.read(new File("filename.png"));
        // update panel with new paint image
        repaint();
    }
}
