
import java.awt.image.BufferedImage;

public class CircleRenderer {
	private BufferedImage img;
	private int color;
	
	public CircleRenderer(BufferedImage img) {
		this(img, 0xffffff);	
	}
	
	public CircleRenderer(BufferedImage img, int color) {
		this.img = img;
		this.color = 0xffffff;
	}
	
	public void drawCircle(int centerX, int centerY, int radius) {
		img.setRGB(centerX, centerY + radius, color);
		img.setRGB(centerX, centerY - radius, color);
		img.setRGB(centerX + radius, centerY, color);
		img.setRGB(centerX - radius, centerY, color);
	}
	
}
