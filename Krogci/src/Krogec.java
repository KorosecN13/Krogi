import java.awt.Graphics;

public class Krogec {
	int x;
	int y;
	int polmer;
	
	public Krogec(int x, int y, int polmer) {
		super();
		this.x = x;
		this.y = y;
		this.polmer = polmer;
	}
	
	public void narisi(Graphics g) {
		g.fillOval(x-polmer, y-polmer, 2*polmer+1, 2*polmer+1);
	}
}
