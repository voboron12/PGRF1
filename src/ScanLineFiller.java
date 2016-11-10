import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class ScanLineFiller extends Filler {
	
	public ScanLineFiller(int color, BufferedImage img){
		super(color,img);
	}
	
	public ScanLineFiller(BufferedImage img){
		super(img);
	}
	
	private List<SLine> lines = new ArrayList<SLine>();
	
	public void fill(PolyLine points) {
		
		int max = (int)points.get(0).getY();
		int min = (int)points.get(0).getY();
		
		for (int i = 0; i < points.size(); i++) {
			
			SLine line = new SLine(points.get(i), points.get((i + 1) % points.size()));
			
			if(!line.isHorizontal()){					
				lines.add(line);
			}
			
			if(max<points.get(i).getY()){
				max = (int)points.get(i).getY();
			}
			
			if(min>points.get(i).getY()){
				min = (int)points.get(i).getY();
			}
		}
		
		for (int y = min; y <= max; y++) {
			List<Integer> intersections = new ArrayList<>();
			for(SLine sl : lines){
				
				if(sl.isIntersection(y)){
					intersections.add(sl.getIntersection(y));
					//TODO setridit seznam a propojit
				}
								
			}
			
			
			
		}
	}
	
	

}