
import java.awt.image.BufferedImage;


public class SeedFill extends Filler {
	
	int[][] pattern = new int[][] {{0xff0000, 0xff, 0xff, 0xff},
							   	   {0xff, 0xff0000, 0xff, 0xff},
							       {0xff, 0xff, 0xff0000, 0xff},
							       {0xff, 0xff, 0xff, 0xff0000}};
	public SeedFill(int color, BufferedImage img) {
		super(color,img);
		this.img = img;
		this.color = color;
	}
	
	public SeedFill(BufferedImage img){
		super(img);
	}
	
	public void fill (int x, int y, int bgColor) {
		if(x > 0 && x < img.getWidth() && y > 0 && y < img.getHeight()){
			if(img.getRGB(x, y) == bgColor) {
				int cP = pattern[x%4][y%4];
				img.setRGB(x, y, cP);		
				fill(x+1, y, bgColor);
				fill(x-1, y, bgColor);
				fill(x, y+1, bgColor);
				fill(x, y-1, bgColor);
			}
		}
	}
}
