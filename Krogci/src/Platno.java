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

public class Platno extends JPanel implements MouseMotionListener, ActionListener {
	List<Krogec> krogci;
	private GlavnoOkno glavnoOkno;
	private OdpiranjeSlike odpiranjeSlike;
	OdpiranjeSlike slika = new OdpiranjeSlike("Golden_ratio_line.png");
	
	public Platno(GlavnoOkno glavno) {
		super();
		this.setBackground(Color.white);
		this.addMouseMotionListener(this);
		this.glavnoOkno = glavno;
		this.krogci = new ArrayList<Krogec>();
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(400, 300);
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
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.glavnoOkno.getOdpriMenu()) {
	//		this.odpiranjeSlike.image("Golden_ratio_line.png");  ASISTENT
			//Kaj se zgodi, ko kliknemo ODPRI
//			this.krogci = new ArrayList<Krogec>();
//			super.repaint();
		}		
	}
	
	public void actionPerformed1(ActionEvent e) {
		if (e.getSource() == this.glavnoOkno.getKrogciMenu()) {
			
			//TODO	//Kaj se zgodi, ko kliknemo Krogci		
			//this.krogci = new ArrayList<Krogec>();
			//super.repaint();
		}	
		}
	}
