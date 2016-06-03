import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;

@SuppressWarnings("serial")
public class GlavnoOkno extends JFrame implements ActionListener {

	private OriginalnoPlatno prvotnaSlika;
	private UstvarjalnoPlatno obdelanaSlika;
	private JMenuItem odpriSlikoMenu;
	private JMenuItem krogciMenu;
	private JMenuItem zamenjajMenu;
	private JMenuItem beleMenu;
	private JMenuItem crneMenu;
	private JMenuItem zamegliMenu;
	private JMenuItem izostriMenu;
	private JFrame okno;
	BufferedImage prenosslike;
	BufferedImage imag;
	File poiscifile;
	

	public GlavnoOkno() throws HeadlessException {
		super();
		this.setTitle("Program�ek");
		this.setLayout(new GridBagLayout());
	
//		JPanel container = new JPanel();
//		container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));
//
//		JPanel panel1 = new OriginalnoPlatno();
//		JPanel panel2 = new UstvarjalnoPlatno();
//
//		panel1.setSize(400, 320);
//		panel2.setSize(300, 450);
//		
////		panel1.setVisible(True);
////		panel2.setVisible(True);
////		
////		
//
//		container.add(panel1);
//		container.add(panel2);
//		
//		panel1.setVisible(true);
//		panel2.setVisible(true);
//		
//		

		prvotnaSlika = new OriginalnoPlatno();
		JScrollPane scrollPane1 = new JScrollPane(prvotnaSlika, 
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.getContentPane().add(scrollPane1);
		
		obdelanaSlika = new UstvarjalnoPlatno();
		JScrollPane scrollPane2 = new JScrollPane(obdelanaSlika, 
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.getContentPane().add(scrollPane2);

		
		// Dodamo menu
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		this.odpriSlikoMenu = new JMenuItem("Odpri", KeyEvent.VK_O);
		menuBar.add(odpriSlikoMenu);
		this.krogciMenu = new JMenuItem("Krogci", KeyEvent.VK_K);
		menuBar.add(krogciMenu);
		this.zamenjajMenu = new JMenuItem("Zamenjaj RGB", KeyEvent.VK_L);
		menuBar.add(zamenjajMenu);
		this.beleMenu = new JMenuItem("Pobeli", KeyEvent.VK_B);
		menuBar.add(beleMenu);
		this.crneMenu = new JMenuItem("Po�rni", KeyEvent.VK_C);
		menuBar.add(crneMenu);
		this.zamegliMenu = new JMenuItem("Zamegli", KeyEvent.VK_Z);
		menuBar.add(zamegliMenu);
		this.izostriMenu = new JMenuItem("Izostri", KeyEvent.VK_I);
		menuBar.add(izostriMenu);
		
		

		
		this.odpriSlikoMenu.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_O, ActionEvent.ALT_MASK));
		this.getOdpriMenu().addActionListener(this);
	
		this.krogciMenu.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_K, ActionEvent.ALT_MASK));
		this.getKrogciMenu().addActionListener(this);
		
		this.zamenjajMenu.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_L, ActionEvent.ALT_MASK));
		this.getZamenjajMenu().addActionListener(this);
		
		this.beleMenu.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_B, ActionEvent.ALT_MASK));
		this.getBeleMenu().addActionListener(this);
		
		this.crneMenu.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_C, ActionEvent.ALT_MASK));
		this.getCrneMenu().addActionListener(this);
		
		this.zamegliMenu.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_Z, ActionEvent.ALT_MASK));
		this.getZamegliMenu().addActionListener(this);
		
		this.izostriMenu.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_I, ActionEvent.ALT_MASK));
		this.getIzostriMenu().addActionListener(this);
		
//		// Dodamo opcijo Krogci
//		JMenuBar menuBar1 = new JMenuBar();
//		this.setJMenuBar(menuBar1);
//		this.krogciMenu = new JMenuItem("Krogci", KeyEvent.VK_K);
//		menuBar1.add(krogciMenu);
//
//		this.krogciMenu.setAccelerator(KeyStroke.getKeyStroke(
//		        KeyEvent.VK_K, ActionEvent.ALT_MASK));
//		this.getZbrisiMenu().addActionListener(this.platno);
		

	}

	public JMenuItem getOdpriMenu() {
		return this.odpriSlikoMenu;
	}
	
	public JMenuItem getKrogciMenu() {
		return this.krogciMenu;	
	}
	
	public JMenuItem getZamenjajMenu() {
		return this.zamenjajMenu;
	}
	
	public JMenuItem getBeleMenu() {
		return this.beleMenu;
	}
	
	public JMenuItem getCrneMenu() {
		return this.crneMenu;
		
	}
	
	public JMenuItem getZamegliMenu() {
		return this.zamegliMenu;
		
	}
	
	public JMenuItem getIzostriMenu() {
		return this.izostriMenu;
		
	}
	
	static BufferedImage Kopija(BufferedImage bi) {
		 ColorModel cm = bi.getColorModel();
		 boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
		 WritableRaster raster = bi.copyData(null);
		 return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == getOdpriMenu()) {
			final JFileChooser fc = new JFileChooser();
			int returnVal = fc.showOpenDialog(null);
			System.out.println(fc.getSelectedFile());
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				try {
				    BufferedImage img = ImageIO.read(fc.getSelectedFile());
					prenosslike = Kopija(img);
					prvotnaSlika.setSize(new Dimension(img.getWidth(), img.getHeight()));	
					obdelanaSlika.setSize(new Dimension(img.getWidth(), img.getHeight()));	
			//		okno.setPreferredSize(new Dimension(2 * img.getWidth(), img.getHeight()));
				    prvotnaSlika.setSlika(img);
				} catch (IOException exc) {}
			}
		}
		else if (e.getSource() == getZamenjajMenu()) {
			BufferedImage img = prenosslike;
			SpremembaRGB.manipulacija(img);
			obdelanaSlika.setBackground(Color.red);
			obdelanaSlika.setSlika(img);
		}
		
		else if (e.getSource() == getBeleMenu()) {
			BufferedImage img = prenosslike;
			BelePike.belepike(img);
			obdelanaSlika.setSlika(img);	
		}
		
		else if (e.getSource() == getCrneMenu()) {
			BufferedImage img = prenosslike;
			CrnePike.crnepike(img);
			obdelanaSlika.setSlika(img);
		}
		
		else if (e.getSource() == getKrogciMenu()) {
			BufferedImage img = prenosslike;
			obdelanaSlika.setSlika(img);	
		}
		
		else if (e.getSource() == getZamegliMenu()) {
			BufferedImage img = prenosslike;
			Zamegli.zamegli(img, 3);
			obdelanaSlika.setSlika(img);
		}
		
		else if (e.getSource() == getIzostriMenu()) {
			BufferedImage img = prenosslike;
			Izostri.izostri(img, 3);
			obdelanaSlika.setSlika(img);
		}
		// DODAJ SCROLLPANE
	}
}