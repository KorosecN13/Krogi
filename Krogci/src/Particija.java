import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.WindowConstants;


public class Particija {
	
	public static void main(String[] args) {
	    GlassView view = new GlassView();
	}

	private static class GlassView extends JFrame {

	    private int width = 200;
	    private int height = 100;

	    public GlassView() {
	        this.setSize(width, height);
	        this.setVisible(true);
	        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	        JPanel glass = new JPanel();
	        glass.setSize(100, 100);
	        glass.setVisible(true);

	        JPanel controls = new JPanel();
	        controls.setSize(100, 100);
	        controls.setBackground(Color.RED);
	        controls.setVisible(true);

	        JSplitPane splitPane = new JSplitPane();
	        splitPane.setSize(width, height);
	        splitPane.setDividerSize(0);
	        splitPane.setDividerLocation(100);
	        splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
	        splitPane.setLeftComponent(controls);
	        splitPane.setRightComponent(glass);

	        this.add(splitPane);
	    }
	}
}
