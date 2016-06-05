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
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;

@SuppressWarnings("serial")
public class GlavnoOkno extends JFrame implements ActionListener {

	private OriginalnoPlatno prvotnaSlika;
	private UstvarjalnoPlatno obdelanaSlika;
	private JMenuItem odpriSlikoMenu;
	private JMenuItem ponastaviMenu;
	private JMenuItem novEfektMenu;
	private JMenuItem zamenjajMenu;
	private JMenuItem beleMenu;
	private JMenuItem crneMenu;
	private JMenuItem zamegliMenu;
	private JMenuItem izostriMenu;
	BufferedImage prenosslike;
	BufferedImage imag;
	BufferedImage zaponastavitev;
	File poiscifile;
	

	public GlavnoOkno() throws HeadlessException {
		super();
		this.setTitle("Programèek");
		this.setLayout(new GridBagLayout());
	

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
		this.ponastaviMenu = new JMenuItem("Ponastavi", KeyEvent.VK_O);
		menuBar.add(ponastaviMenu);
		this.novEfektMenu = new JMenuItem("Nov efekt", KeyEvent.VK_K);
		menuBar.add(novEfektMenu);
		this.zamenjajMenu = new JMenuItem("Zamenjaj RGB", KeyEvent.VK_L);
		menuBar.add(zamenjajMenu);
		this.beleMenu = new JMenuItem("Pobeli", KeyEvent.VK_B);
		menuBar.add(beleMenu);
		this.crneMenu = new JMenuItem("Poèrni", KeyEvent.VK_C);
		menuBar.add(crneMenu);
		this.zamegliMenu = new JMenuItem("Zamegli", KeyEvent.VK_Z);
		menuBar.add(zamegliMenu);
		this.izostriMenu = new JMenuItem("Izostri", KeyEvent.VK_I);
		menuBar.add(izostriMenu);
		
		

		
		this.odpriSlikoMenu.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_O, ActionEvent.ALT_MASK));
		this.getOdpriMenu().addActionListener(this);
	
		this.ponastaviMenu.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_O, ActionEvent.ALT_MASK));
		this.getPonastaviMenu().addActionListener(this);
		
		this.novEfektMenu.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_K, ActionEvent.ALT_MASK));
		this.getNovEfekt().addActionListener(this);
		
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


	}

	public JMenuItem getOdpriMenu() {
		return this.odpriSlikoMenu;
	}
	
	public JMenuItem getPonastaviMenu() {
		return this.ponastaviMenu;
	}
	
	public JMenuItem getNovEfekt() {
		return this.novEfektMenu;	
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
					zaponastavitev = Kopija(img);
					prvotnaSlika.setSize(new Dimension(img.getWidth(), img.getHeight()));	
					obdelanaSlika.setSize(new Dimension(img.getWidth(), img.getHeight()));	
			//		okno.setPreferredSize(new Dimension(2 * img.getWidth(), img.getHeight()));
				    prvotnaSlika.setSlika(img);
				} catch (IOException exc) {}
			}
		}
		else if (e.getSource() == getPonastaviMenu()) {
			BufferedImage img = zaponastavitev;
			prenosslike = Kopija(zaponastavitev);
			obdelanaSlika.setSlika(img);
		}
		else if (e.getSource() == getZamenjajMenu()) {
			BufferedImage img = prenosslike;
			SpremembaRGB.manipulacija(img);
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
		
		else if (e.getSource() == getNovEfekt()) {
			BufferedImage img = prenosslike;
			NovEfekt.novEfekt(img, 3);
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
		
		

	}
}