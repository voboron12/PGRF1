import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import transforms.Mat3Rot2D;
import transforms.Point2D;

public class PolyLine {

	List<Point2D> points;

	public PolyLine() {
		points = new ArrayList<Point2D>();
	}

	public void add(double x, double y) {
		points.add(new Point2D(x, y));
	}

	public List<Point2D> rotate(double angle) {
		Mat3Rot2D mat = new Mat3Rot2D(angle);
		Point2D e = new Point2D(points.get(0));
		Point2D p = new Point2D(e.getX(), e.getY());

		p = p.mul(mat);

		List<Point2D> transformedPoints = new ArrayList<Point2D>();

		for (Point2D k : points) {
			transformedPoints.add(k.mul(mat));
		}

		return transformedPoints;
	}

	public Point2D get(int i){
		return points.get(i);
	}
	
	public int size(){
		return points.size();
	}
	
}
