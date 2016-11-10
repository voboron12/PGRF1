
import java.awt.image.BufferedImage;

public abstract class Filler {
	protected int color;
	protected BufferedImage img;
	
	public Filler(int color, BufferedImage img) {
		this.color = color;
		this.img = img;		
	}
	
	public Filler(BufferedImage img){
		this(0xff0000, img);
	}
	
}
