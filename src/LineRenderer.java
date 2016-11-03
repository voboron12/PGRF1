
import java.awt.image.BufferedImage;

public class LineRenderer {
	private BufferedImage img;
	private int color;
	
	public LineRenderer(BufferedImage img) {
		this(img, 0xffffff);	
	}
	
	public LineRenderer(BufferedImage img, int color) {
		this.img = img;
		this.color = 0xffffff;
	}
	
	public void drawLine (int xA, int xB, int yA, int yB) {
		
		double k = (double)(yB -yA) / (double)(xB - xA);
		double q = yA - k*xA;
	
		
		if(k<1) {
			for(int x = xA; x <= xB; x++) {
				int y = (int)(k*x + q + 0.5); 
				img.setRGB(x, y, color);
			
			}
		}else{		
			for(int y = yA; y <= yB; y++) {
				int x = (int)((y-q)/k); 
				img.setRGB(x, y, color);
			}
		}
	}
	
	public void drawLineTrivial (int x1, int y1, int x2, int y2) {
		if ((x1 == x2) && (y1 == y2)) {
			img.setRGB(x1, y1, color);
		}

		// test pro kolmici k ose x
		if (x2 - x1 != 0) {
			double k = (double) (y2 - y1) / (double) (x2 - x1);
			double q = y1 - k * x1;

			// smernice mezi -1 a 1
			if (Math.abs(k) < 1) {
				if (x1 < x2) {
					for (int x = x1; x <= x2; x++) {
						int y = (int) (k * x + q + 0.5);
						img.setRGB(x, y, color);
					}
				} else {
					for (int x = x2; x <= x1; x++) {
						int y = (int) (k * x + q + 0.5);
						img.setRGB(x, y, color);
					}
				}
				// smernice vne -1 a 1
			} else {
				if (y1 < y2) {
					for (int y = y1; y <= y2; y++) {
						int x = (int) ((y - q) / k);
						img.setRGB(x, y, color);
					}
				} else {
					for (int y = y2; y <= y1; y++) {
						int x = (int) ((y - q) / k);
						img.setRGB(x, y, color);
					}
				}
			}
			// vykresli kolmici k ose x
		} else {
			if (y1 < y2) {
				for (int y = y1; y < y2; y++) {
					img.setRGB(x1, y, 0xffffff);
				}
			} else {
				for (int y = y2; y < y1; y++) {
					img.setRGB(x1, y, 0xffffff);
				}
			}
		}


	}
	public void setColor(int color) {
		this.color = color;
	}
}
