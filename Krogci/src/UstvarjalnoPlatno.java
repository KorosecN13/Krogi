import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class UstvarjalnoPlatno extends JPanel {
private BufferedImage slika;
SpremembaRGB m = new SpremembaRGB();
	

	public UstvarjalnoPlatno() {
		super();
		this.setBackground(Color.white);
	}

	@Override
	public Dimension getPreferredSize() {
		if (slika != null) {
			return new Dimension(slika.getWidth(), slika.getHeight());
		}
		return new Dimension(500, 500);
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (slika != null) {
			g.drawImage(slika, 0, 0, null);
		}
	}


	public void setSlika(BufferedImage img) {
		slika = img;
		repaint();
	}
	
    public void save(BufferedImage img) throws IOException{
        ImageIO.write(img, "PNG", new File("filename.png"));
    }

    public void load() throws IOException {
        BufferedImage paintImage = ImageIO.read(new File("filename.png"));
        // update panel with new paint image
        repaint();
    }
}
