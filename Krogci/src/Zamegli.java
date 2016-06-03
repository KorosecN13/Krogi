import java.awt.Color;
import java.awt.image.BufferedImage;

public class Zamegli {
	//2. matrika je jedro, sicer se koeficient napiše drugaè
	public static double konvolucija(int[][] rdecaMatrika, int[][] matrika2, int velikostmatrike){
		double sestevek = 0;
		int koeficient = 0;
		for (int i = 0; i < velikostmatrike; i++){
			for (int j = 0; j < velikostmatrike; j++){
				sestevek += rdecaMatrika[i][j]*matrika2[velikostmatrike-1-i][velikostmatrike-1-j];
				koeficient += matrika2[i][j];
			}
		}
		return (sestevek/koeficient);
	}

	public static void zamegli(BufferedImage slika){
		int sirina = slika.getWidth();	
		int visina = slika.getHeight();
		int velikostJedra;
		velikostJedra = 3;
		int[][] jedro = {{1,1,1},
				 		{1,1,1},
				 		{1,1,1}};
				
		for(int i = 1; i < sirina-1; i++){
			for(int j = 1; j < visina-1; j++){
		
				int podatek =	slika.getRGB(i, j);
			    Color c = new Color(podatek);
			
			    int rdeca = c.getRed();  
			    int zelena = c.getGreen();
			    int modra =  c.getBlue(); 
			    int alfa = c.getAlpha();

			    
			    int[][] rdecaMatrika = new int[velikostJedra][velikostJedra];
			    int[][] modraMatrika = new int[velikostJedra][velikostJedra];
			    int[][] zelenaMatrika = new int[velikostJedra][velikostJedra];
			    
			    for (int m = -(velikostJedra-1)/2; m < (velikostJedra+1)/2; m++){
			    	for (int n = -(velikostJedra-1)/2; n < (velikostJedra+1)/2; n++){   	
			    		Color d = new Color(slika.getRGB(i+m,j+n));
			    		rdecaMatrika[m +(velikostJedra-1)/2 ][n + (velikostJedra-1)/2] = d.getRed();
			    		zelenaMatrika[m +(velikostJedra-1)/2][n + (velikostJedra-1)/2] = d.getGreen();
			    		modraMatrika[m +(velikostJedra-1)/2][n + (velikostJedra-1)/2] = d.getBlue();
			    	}
			    }
			 
			    double rdeca1 = konvolucija(rdecaMatrika, jedro, 3);
			    double modra1 = konvolucija(modraMatrika, jedro, 3);
			    double zelena1 = konvolucija(zelenaMatrika, jedro, 3);
			    
			    int rgb = (int) rdeca1;
			    rgb = (int) ((rgb << 8) + zelena1);
			    rgb = (int) ((rgb << 8) + modra1);	
			    slika.setRGB(i, j, rgb);
			
			}
		}
	}
}