import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Platno extends JPanel implements MouseMotionListener, ActionListener {
	List<Krogec> krogci;
	public Platno(GlavnoOkno glavno) {
		super();
		this.setBackground(Color.white);
		this.addMouseMotionListener(this);
		this.krogci = new ArrayList<Krogec>();
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(500, 500);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Krogec k : this.krogci) {
			k.narisi(g);
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		Graphics g = this.getGraphics();
		Krogec k = new Krogec(e.getX(), e.getY(), 2);
		k.narisi(g);
		this.krogci.add(k);
	}

	@Override
	public void mouseMoved(MouseEvent e) {		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
	}
}


