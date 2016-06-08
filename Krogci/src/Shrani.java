import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JPanel;
import javax.imageio.ImageIO;

@SuppressWarnings("serial")
public class Shrani extends JPanel{
	static int a = 1;
	
    public static void shrani(BufferedImage img) throws IOException{
        ImageIO.write(img, "PNG", new File("filename" + a + ".png"));
        a += 1;
    }
}
