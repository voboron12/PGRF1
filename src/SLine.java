

import transforms.Point2D;

public class SLine {

	private Point2D a;
	private Point2D b;

	public SLine(Point2D a, Point2D b) {
		this.a = a;
		this.b = b;
	}

	public boolean isHorizontal() {
		
		Double a1 = new Double(a.getY()); 
		Double b1 = new Double(b.getY());
		
		return (a1.equals(b1));
	}

	public void changeDirection() {

		if (a.getY() > b.getY()) {
			Point2D temp;
			temp = a;
			a = b;
			b = a;
		}
	}

	public boolean isIntersection(int y) {
		return (a.getY() <= y || b.getY() >= y);
	}

	public int getIntersection(int y) {
		return 0;
	}
}
