import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.*;
import javax.swing.*;


@SuppressWarnings("serial")
public class OdpiranjeSlike extends JFrame {
    BufferedImage image;	

	public OdpiranjeSlike(final String filename) throws RuntimeException{
		SwingUtilities.invokeLater(new Runnable(){
			
			public void run(){
				JFrame editorFrame = new JFrame("Odpremo Sliko");
				editorFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
				image = null;
				try{
					image = ImageIO.read(new File(filename));
				}
				catch (Exception e){
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

