import java.awt.Color;
import java.awt.image.BufferedImage;

public class Zamegli {
	//2. matrika bo jedro
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

	
	public static void zamegli(BufferedImage slika, int vjedra){
		int sirina = slika.getWidth();	
		int visina = slika.getHeight();
		int velikostJedra = vjedra;
		int[][] jedro = {{1,1,1},
				 		{1,1,1},
				 		{1,1,1}};
				
		for(int i = (velikostJedra-1)/2; i < sirina-(velikostJedra-1)/2; i++){
			for(int j = (velikostJedra-1)/2; j < visina-(velikostJedra-1)/2; j++){


			    //matrike, ki predstavljajo povpreèno kolièino rgb barv v okolici toèke i,j
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
			    // izraèun kolièine rgb barve na toèki i,j glede na konvolucijsko množenje matrike posamezne barvne 
			    // komponente z jedrom
			    double rdeca1 = konvolucija(rdecaMatrika, jedro, velikostJedra);
			    double modra1 = konvolucija(modraMatrika, jedro, velikostJedra);
			    double zelena1 = konvolucija(zelenaMatrika, jedro, velikostJedra);
			    
			    // nastavitev dobljenih barv v binarni zapis
			    int rgb = (int) rdeca1;
			    rgb = (int) ((rgb << 8) + zelena1);
			    rgb = (int) ((rgb << 8) + modra1);	
			    slika.setRGB(i, j, rgb);
			
			}
		}
	}
}