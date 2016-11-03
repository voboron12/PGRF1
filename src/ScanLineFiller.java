import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class ScanLineFiller extends Filler {

	public void fill(List<Point> points) {
		List<SLine> lines = new ArrayList<SLine>();

		for (int i = 0; i < points.size(); i++) {
			
			SLine line = new SLine(points.get(i), points.get((i + 1) % points.size()));
			
			if(!line.isHorizontal()){					
				lines.add(line);
			}
			
			
		}
		
	}

}
