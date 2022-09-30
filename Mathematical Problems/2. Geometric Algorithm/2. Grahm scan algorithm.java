// Java program to find convex hull of a set of points using Graham Scan Algorithm.
import java.util.*;

class Point
{
	int x, y;
	Point(int x, int y){
		this.x=x;
		this.y=y;
	}
}

class PointsComparator implements Comparator<Point>
{
    static Point p0;
    
	public int compare(Point p1, Point p2)
	{
	    return Solution.orientation(p0,p1,p2);
	}
}

class Solution {
	
	public static int orientation(Point p, Point q, Point r)
	{
		int val = (q.y - p.y) * (r.x - q.x) -
				(q.x - p.x) * (r.y - q.y);
		return val;
	}
	
	// Prints convex hull of a set of n points.
	public static ArrayList<Point> convexHull(Point arr[], int n)
	{

		int b=0;
		for(int i=1;i<n;i++)
		{
		    int y=arr[i].y;
		    if(y<arr[b].y || (y==arr[b].y && arr[i].x<arr[b].x))
		    {
		        b=i;
		    }
		}
		Point temp=arr[0];
		arr[0]=arr[b];
		arr[b]=temp;
		
		PointsComparator.p0=arr[0];
		
		Arrays.sort(arr,new PointsComparator());
		
		ArrayList<Point> s=new ArrayList<>();
		s.add(arr[0]);
	    s.add(arr[1]);
	    for(int i=2;i<n;i++)
	    {
	        while(s.size()>=2 && orientation(s.get(s.size()-2),s.get(s.size()-1),arr[i])>=0)
	            s.remove(s.size()-1);
	        s.add(arr[i]);
	    }
	    
	    return s;
	}
}

public class Test{
	
	public static void main(String[] args)
	{
			Point points[] = {new Point(1,2),new Point(15,-2),new Point(22,13),new Point(5,10),new Point(5,5),new Point(8,8),new Point(10,5),new Point(15,7),new Point(10,9),new Point(0,3)};
		//  Point points[] = {new Point(1,4),new Point(5,5),new Point(3,3),new Point(4,1),new Point(4,-1),new Point(1,-2)};
		//  Point points[] = {new Point(5, 0),new Point(1, 1),new Point(3, 2),new Point(0, -1),new Point(0, 5)};
		//	Point points[] = {new Point(2,2),new Point(4,3),new Point(5,4),new Point(0,3),new Point(2,1),new Point(0,0),new Point(4,0)};
		//  Point points[] = {new Point(0, 10),new Point(7, 9),new Point(3, 7),new Point(0, -2),new Point(0, 5),new Point(15, 15)};
		int n = points.length;
		ArrayList<Point>  s = Solution.convexHull(points, n);
	    for(Point p:s)
	        System.out.println(p.x+" "+p.y);
		
	}
}
