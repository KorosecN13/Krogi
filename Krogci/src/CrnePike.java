import java.awt.Color;
import java.awt.image.BufferedImage;

public class CrnePike {

	public static void crnepike(BufferedImage slika){
		int sirina = slika.getWidth();	
		int visina = slika.getHeight();
		
		for(int i = 0; i < sirina; i++){
			for(int j = 0; j < visina; j++){
		
				int podatek =	slika.getRGB(i, j);
			    Color c = new Color(podatek);
			
			    int rdeca = c.getRed();  
			    int zelena = c.getGreen();
			    int modra =  c.getBlue();  
			    
			    
			    
			    int rgb = rdeca;
			    rgb = (rgb << 8) + zelena;
			    rgb = (rgb << 8) + modra;
			    
			    if ((i+j)%2 == 0)	
			    	slika.setRGB(i, j,  0x000000);
			
	}}}
}
