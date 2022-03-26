import java.util.Vector;

class Point {
	int x, y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
}

class Solution {
	
	static Vector<Point> hull = new Vector<Point>();

	public  static int orientation(Point p, Point q, Point r) {
		int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);

		if (val == 0) {
			return 0; // collinear
		}
		return (val > 0) ? 1 : 2; // clock or counterclock wise
	}

	public static Vector<Point> convexHull(Point points[], int n) {

		int I = 0;
		for (int i = 1; i < n; i++) {
			if (points[i].x < points[I].x)
				I = i;
		}

		int p = I, q;
		do {
			hull.add(points[p]);
			q = (p + 1) % n;
			for (int i = 0; i < n; i++) {
				if (orientation(points[p], points[i], points[q]) == 2)
					q = i;
			}

			p = q;

		} while (p != I); // While we don't come to first
							// point

		return hull;		
	}
}

public class Test {
	public static void main(String[] args)
	{

		Point points[] = new Point[7];
		points[0]=new Point(2,2);
		points[1]=new Point(4,3);
		points[2]=new Point(5,4);
		points[3]=new Point(0,3);
		points[4]=new Point(2,1);
		points[5]=new Point(0,0);
		points[6]=new Point(4,0);
		
		int n = points.length;
		 Vector<Point> hull = Solution.convexHull(points, n);
		for (Point temp : hull)
			System.out.println("(" + temp.x + ", " + temp.y + ")");
		
	}
}
