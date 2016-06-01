import java.awt.Color;
import java.awt.image.BufferedImage;

public class SpremembaRGB {

	public static void manipulacija(BufferedImage slika){
			
		int sirina = slika.getWidth();	
		int visina = slika.getHeight();
		
		for(int i = 0; i < sirina; i++){
			for(int j = 0; j < visina; j++){
		
				int podatek =	slika.getRGB(i, j);
			    Color c = new Color(podatek);
			
			    int rdeca = c.getRed();  
			    int zelena = c.getGreen();
			    int modra =  c.getBlue(); 
			    int alfa = c.getAlpha(); 
			    
			    int modra1 = modra;
			    int zelena1 = zelena;
			    int rdeca1 = rdeca;
			    modra = rdeca;
			    rdeca = zelena;
			    zelena = modra;
			    
			    int rgb = rdeca;
			    rgb = (rgb << 8) + zelena;
			    rgb = (rgb << 8) + modra;
			    
			    slika.setRGB(i, j, rgb);
			    
			  
			}
					
			}
		}
		
	}
		

			


