import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;

public class Izostri {
	//2. matrika je jedro, sicer se koeficient napiše drugaè
	public static double konvolucija(int[][] matrika1, int[][] matrika2, int velikostmatrike){
		double sestevek = 0;
		for (int i = 0; i < velikostmatrike; i++){
			for (int j = 0; j < velikostmatrike; j++){
				sestevek += matrika1[i][j]*matrika2[velikostmatrike-1-i][velikostmatrike-1-j];
			}
		}
		return (sestevek);
	}

	static BufferedImage Kopija(BufferedImage bi) {
		 ColorModel cm = bi.getColorModel();
		 boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
		 WritableRaster raster = bi.copyData(null);
		 return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
		}
	
	
	public static void izostri(BufferedImage slika, int vjedra){
		int sirina = slika.getWidth();	
		int visina = slika.getHeight();
		int velikostJedra = vjedra;
		int[][] jedro = {{0,-1,0},
				 		{-1,5,-1},
				 		{0,-1,0}};
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
			 
			    double rdeca1 = konvolucija(rdecaMatrika, jedro, 3);
			    double modra1 = konvolucija(modraMatrika, jedro, 3);
			    double zelena1 = konvolucija(zelenaMatrika, jedro, 3);
			    if (rdeca1 > maksimum){
			    	maksimum = rdeca1;}
			    if (zelena1 > maksimum){
			    	maksimum = zelena1;}
			    if (modra1 > maksimum){
			    	maksimum = modra1;}
			    int rgb = (int) Math.max(0,Math.min(255, rdeca1));
			    rgb = (int) ((rgb << 8) + Math.max(0,Math.min(255, zelena1)));
			    rgb = (int) ((rgb << 8) + Math.max(0,Math.min(255, modra1)));	
			    slika.setRGB(i, j, rgb);
			}
		}
		System.out.println(maksimum);
	}
	
}