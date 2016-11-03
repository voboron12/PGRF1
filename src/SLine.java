import java.awt.Point;

public class SLine {

	private Point a;
	private Point b;

	public SLine(Point a, Point b) {
		this.a = a;
		this.b = b;
	}

	public boolean isHorizontal() {
		return (a.getY() == b.getY());
	}

	public void changeDirection() {

		if (a.getY() > b.getY()) {
			Point temp;
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
