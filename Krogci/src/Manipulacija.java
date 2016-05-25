import java.awt.image.BufferedImage;

public class Manipulacija {
	
	public static void main(String[] args) throws Exception{
		
		OdpiranjeSlike slika = new OdpiranjeSlike(null);
		
		Color mojaBarva = new Color(null);                 // ASISTENT		
		int a;
		int b;
		int c;
		
		Trojèek(a, b, c) {
			this.a = a;
			this.b = b;
			this.c = c;
				}
		
		Trojèek[][] konecPiksli = new Trojèek(null, null, null);
		
		int sirina = slika.image.getWidth(null);	
		int visina = slika.image.getHeight(null);
		
		int Tabela = int[sirina][visina]
		
		int[][] piksli = new int[sirina][visina];
		for(int i = 0; i < sirina; i++)
			for(int j = 0; j < visina; j++)
				piksli[i][j] = image.getRGB( i, j);       //ASISTENT
				mojaBarva = Color(piksli[i][j])
				//int red = mojaBarva.getRed()
				Trojèek[][] konecPiksli = new Trojèek(mojaBarva.getRed(),
													  mojaBarva.getGreen(),
													  mojaBarva.getBlue()); 
				Tabela[i][j] = konecPiksli;
				
				

		System.out.println(piksli[10][10]);		
		
	}
			
			

}
