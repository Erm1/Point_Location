/*
Ermiyas Liyeh
30711570
CSC 172 Online- Summer 2019
I did not collaborate with anyone on this assignment.
*/

public class Point {
	
	protected double x;
	protected double y;
	
	public Point(double x, double y){
		
		this.x = x;
		this.y = y;
		
	}
	
	public String toString(){
		
		return String.format("(%.2f, %.2f)", this.x, this.y);
		
	}
	
}