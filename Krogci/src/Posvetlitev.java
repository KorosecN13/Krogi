import java.awt.Color;
import java.awt.image.BufferedImage;

public class Posvetlitev {

	public static void posvetlitev(BufferedImage slika){
		int sirina = slika.getWidth();	
		int visina = slika.getHeight();
		
		for(int i = 0; i < sirina; i++){
			for(int j = 0; j < visina; j++){
		
				int podatek =	slika.getRGB(i, j);
			    Color c = new Color(podatek);
			
			    int rdeca = c.getRed();  
			    int zelena = c.getGreen();
			    int modra =  c.getBlue();  
			    
			    //za potemnitev namesto (255 + n)/2 napišemo samo n/2
			    float rdeca1 = (255 + rdeca)/2;
			    float zelena1 = (255 + zelena)/2;
			    float modra1 = (255 + modra)/2;
			    
			    
			    int rgb = (int) rdeca1;
			    rgb = (rgb << 8) + (int) zelena1;
			    rgb = (rgb << 8) + (int) modra1;
			    
			    slika.setRGB(i, j,  rgb);
			    
			}
		}
	}
}
