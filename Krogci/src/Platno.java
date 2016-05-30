import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Platno extends JPanel {
	private BufferedImage slika;
	
	public Platno() {
		super();
		this.setBackground(Color.white);
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