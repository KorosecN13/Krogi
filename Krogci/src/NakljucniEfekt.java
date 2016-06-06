import java.awt.Color;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;

public class NakljucniEfekt {
	//2. matrika je jedro, sicer se koeficient napiše drugaè
	public static double konvolucija(int[][] matrika1, int[][] matrika2, int velikostmatrike){
		double sestevek = 0;
		for (int i = 0; i < velikostmatrike; i++){
			for (int j = 0; j < velikostmatrike; j++){
				sestevek += matrika1[i][j]*matrika2[velikostmatrike-1-i][velikostmatrike-1-j];
			}
		}
		return (sestevek/2);
	}

	static BufferedImage Kopija(BufferedImage bi) {
		 ColorModel cm = bi.getColorModel();
		 boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
		 WritableRaster raster = bi.copyData(null);
		 return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
		}
	
	
	public static void nakljucniEfekt(BufferedImage slika, int vjedra){
		int sirina = slika.getWidth();	
		int visina = slika.getHeight();
		int velikostJedra = vjedra;
		int a = 0;
		int vsota = 0;


//		int[][] jedro = {{-2,0,0},
//				 		{0,4,0},
//				 		{0,0,-2}};
		int[][] jedroMatrika = new int[velikostJedra][velikostJedra];
		for (int t = 0; t < velikostJedra; t++){
			for (int r = 0; r < velikostJedra; r++){
				if (t != (velikostJedra-1)/2 || r != (velikostJedra-1)/2)
					a = ThreadLocalRandom.current().nextInt(-5, 5);
					jedroMatrika[t][r] = a;
					vsota +=a;
			}
		}
		jedroMatrika[(velikostJedra-1)/2][(velikostJedra-1)/2] = -(vsota);
		
		BufferedImage kopija = Kopija(slika);
		double maksimum = 0;
				
		for(int i = (velikostJedra-1)/2; i < sirina-(velikostJedra-1)/2; i++){
			for(int j = (velikostJedra-1)/2; j < visina-(velikostJedra-1)/2; j++){
		
			    
			    int[][] rdecaMatrika = new int[velikostJedra][velikostJedra];
			    int[][] modraMatrika = new int[velikostJedra][velikostJedra];
			    int[][] zelenaMatrika = new int[velikostJedra][velikostJedra];
			    
			    for (int m = -(velikostJedra-1)/2; m < (velikostJedra+1)/2; m++){
			    	for (int n = -(velikostJedra-1)/2; n < (velikostJedra+1)/2; n++){   	
			    		Color d = new Color(kopija.getRGB(i+m,j+n));
			    		rdecaMatrika[m +(velikostJedra-1)/2 ][n + (velikostJedra-1)/2] = d.getRed();
			    		zelenaMatrika[m +(velikostJedra-1)/2][n + (velikostJedra-1)/2] = d.getGreen();
			    		modraMatrika[m +(velikostJedra-1)/2][n + (velikostJedra-1)/2] = d.getBlue();
			    	}
			    }
			 
			    double rdeca1 = konvolucija(rdecaMatrika, jedroMatrika, 3);
			    double modra1 = konvolucija(modraMatrika, jedroMatrika, 3);
			    double zelena1 = konvolucija(zelenaMatrika, jedroMatrika, 3);
			    if (rdeca1 > maksimum){
			    	maksimum = rdeca1;}
			    if (zelena1 > maksimum){
			    	maksimum = zelena1;}
			    if (modra1 > maksimum){
			    	maksimum = modra1;}
			    int rgb = (int) rdeca1;
			    rgb = (int) ((rgb << 8) + zelena1);
			    rgb = (int) ((rgb << 8) + modra1);	
			    slika.setRGB(i, j, rgb);
			
			}
		}
		System.out.println(maksimum);
	}
	
}