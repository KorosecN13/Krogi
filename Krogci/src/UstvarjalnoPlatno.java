import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;


public class UstvarjalnoPlatno extends JPanel {
private BufferedImage slika;
Manipulacija m = new Manipulacija();
	

	public UstvarjalnoPlatno() {
		super();
		this.setBackground(Color.blue);
	}

	@Override
	public Dimension getPreferredSize() {
		if (slika != null) {
			return new Dimension(slika.getWidth(), slika.getHeight());
		}
		return new Dimension(400, 300);
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
}
