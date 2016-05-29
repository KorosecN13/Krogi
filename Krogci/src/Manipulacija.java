import java.awt.image.BufferedImage;
import java.awt.Color;

public class Manipulacija {

	public static void main(String[] args) throws Exception{
		
		OdpiranjeSlike slika = new OdpiranjeSlike(null);
		

		
		int sirina = slika.image.getWidth();	
		int visina = slika.image.getHeight();
		
		
		int[][] piksli = new int[sirina][visina];
		for(int i = 0; i < sirina; i++){
			for(int j = 0; j < visina; j++){
				Color c = new Color(slika.getRGB(i, j));  
				piksli[i][j] = c;
			}
		}
				
				//int red = mojaBarva.getRed()
					
			
				
				

		System.out.println(piksli[10][10]);		
		
	}
			
			

}
