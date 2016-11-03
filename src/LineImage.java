
import java.awt.image.BufferedImage;

public class LineImage {
	private int xA;
	private int xB;
	private int yA;
	private int yB;
	
	public LineImage(int xA, int xB, int yA, int yB) {
		this.xA = xA;
		this.xB = xB;
		this.yA = yA;
		this.yB = yB;
	}
	
	
	public void draw (BufferedImage img) {		
		double k = (double)(yB -yA) / (double)(xB - xA);
		double q = yA - k*xA;
	
		
		if(k<1) {
			for(int x = xA; x <= xB; x++) {
				int y = (int)(k*x + q + 0.5); 
				img.setRGB(x, y, 0xffffff);
			
			}
		}else{		
			for(int y = yA; y <= yB; y++) {
				int x = (int)((y-q)/k); 
				img.setRGB(x, y, 0x0000ff);
			}
		}
	}
}
