/*
Ermiyas Liyeh
30711570
CSC 172 Online- Summer 2019
I did not collaborate with anyone on this assignment.
*/

public class Line {
	
	protected Point start;
	protected Point end;
	protected int lineNum;
	
	public static final int COUNTERCLOCKWISE=1;
	public static final int CLOCKWISE=2;
	public static final int COLINEAR=3;
	

	public Line(double x1, double y1, double x2, double y2){
		this.start = new Point(x1,y1);
		this.end = new Point(x2,y2);
	}

	public Line (Point p1, Point p2){
		this.start = p1;
		this.end = p2;
	}
	
	public boolean intersects(Line line1, Line line2){
		double x1 = line1.start.x;
		double y1 = line1.start.y;
		double x2 = line1.end.x;
		double y2 = line1.end.y;
		double x3 = line2.start.x;
		double y3 = line2.start.y;
		double x4 = line2.end.x;
		double y4 = line2.end.y;
		double d = (x1-x2)*(y3-y4) - (y1-y2)*(x3-x4); 
		
		if (d == 0){
			return false; 
		}
		
		double xIntersect = ((x3-x4)*(x1*y2-y1*x2)-(x1-x2)*(x3*y4-y3*x4))/d;
		double yIntersect = ((y3-y4)*(x1*y2-y1*x2)-(y1-y2)*(x3*y4-y3*x4))/d;
		
		if ((x3 == x4) && (yIntersect < Math.min(y1, y2) || yIntersect > Math.max(y1, y2))){
				return false; 
		} 
		if (xIntersect < Math.min(x1, x2) || xIntersect > Math.max(x1, x2)){
			return false; 
		}
		if (xIntersect < Math.min(x3, x4) || xIntersect > Math.max(x3, x4)){ 
			return false;
		}
		return true;
	}

	public int testPoint(Point p0) {
		Point p1 = this.start;
		Point p2 = this.end;
		double dx1 = p1.x - p0.x;
		double dy1 = p1.y - p0.y;
		double dx2 = p2.x - p0.x;
		double dy2 = p2.y - p0.y;
		if (dx1*dy2 > dy1*dx2){
			return COUNTERCLOCKWISE;
		} else if (dx1*dy2 < dy1*dx2){
			return CLOCKWISE;
		} else if ((dx1*dx2 < 0) || (dy1*dy2 < 0)){
			return CLOCKWISE;
		} else if ((dx1*dx1+dy1*dy1) < (dx2*dx2+dy2*dy2)){
			return COUNTERCLOCKWISE;
		} else {
			return COLINEAR;
		}
	}
	
	public String toString(){
		String s = String.format("(%.2f, %.2f),(%.2f, %.2f)", start.x, start.y, end.x, end.y);
		//String s = Integer.toString(this.lineNum);
		return s;
	}

}