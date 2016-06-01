import java.awt.Color;
import java.awt.image.BufferedImage;

public class Manipulacija {

	public static void manipulacija(BufferedImage slika){
			
		int sirina = slika.getWidth();	
		int visina = slika.getHeight();
		System.out.println(sirina);
		
		for(int i = 0; i < sirina; i++){
			for(int j = 0; j < visina; j++){
				System.out.println(1);
				System.out.println(i);
			//	int[] podatek = slika.getRGB(0, 0, visina, sirina, null, 0, visina); 
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
		
		
//		Color[][] piksli = new Color[sirina][visina];
//		for(int i = 0; i < sirina; i++){
//			for(int j = 0; j < visina; j++){
//				Color c = new Color(slika.getRGB(i, j));  
//				piksli[i][j] = c;	
//			}
//		}
				//int red = mojaBarva.getRed()
		
		//System.out.println(piksli[10][10]);		
		
	
			
			


