import java.awt.*;
import java.awt.image.*;
import java.io.*;

import javax.imageio.*;
import javax.swing.*;

/**
 * A Java class to demonstrate how to load an image from disk with the
 * ImageIO class. Also shows how to display the image by creating an
 * ImageIcon, placing that icon an a JLabel, and placing that label on
 * a JFrame.
 * 
 * @author alvin alexander, devdaily.com
 */

@SuppressWarnings("serial")
public class OdpiranjeSlike extends JFrame {
	
    BufferedImage image;	

//public class OdpiranjeSlike
//{
//  public static void main(String[] args) throws Exception
//  {
//    new OdpiranjeSlike(args[0]);
//  }

	public OdpiranjeSlike(final String filename) throws RuntimeException{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run(){
        JFrame editorFrame = new JFrame("Odpremo Sliko");
        editorFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        image = null;
        try
        {
          image = ImageIO.read(new File(filename));
        }
        catch (Exception e)
        {
          e.printStackTrace();
          System.exit(1);
        }
        ImageIcon imageIcon = new ImageIcon(image);
        JLabel jLabel = new JLabel();
        jLabel.setIcon(imageIcon);
        editorFrame.getContentPane().add(jLabel, BorderLayout.CENTER);

        editorFrame.pack();
        editorFrame.setLocationRelativeTo(null);
        editorFrame.setVisible(true);
      }
    });
  }
}

