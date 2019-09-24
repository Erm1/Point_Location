/*
Ermiyas Liyeh
30711570
CSC 172 Online- Summer 2019
I did not collaborate with anyone on this assignment.
*/

public class BinaryTree{
	
	public Node root;
	public int nodes;
	
	public static final int CLOCKWISE = -1;
	public static final int COUNTERCLOCKWISE = 1;
	public static final int COLINEAR = 0;
	
	public BinaryTree(){
		this.root = null;
		this.nodes = 0;
	}
	
	public Node insert(Line line, Node node) {
		if (root == null){
			root = new Node(line);
			nodes=1;
			return root;
		}
		
		if (line.intersects(line, node.data)){
			if (node.leftChild != null){
				node.leftChild = insert(line, node.leftChild);
			} else {
				node.leftChild = new Node(line, node);
				nodes++;
			}
			if (node.rightChild != null){
				node.rightChild = insert(line, node.rightChild);
			} else {
				node.rightChild = new Node(line, node);
				nodes++;
			}
			
		} else if (ccw(line.start, node.data.start, node.data.end) == CLOCKWISE){
			if (node.rightChild != null){
				node.rightChild = insert(line, node.rightChild);
			} else {
				node.rightChild = new Node(line, node);
				nodes++;
			}
		} else if (ccw(line.start, node.data.start, node.data.end) == COUNTERCLOCKWISE){
			if (node.leftChild != null){
				node.leftChild = insert(line, node.leftChild);
			} else {
				node.leftChild = new Node(line, node);
				nodes++;
			}
		}
		return node;
	}
	
	public int ccw(Point p0, Point p1, Point p2) { 
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
	
	public Line test(Node node, Point p1, Point p2){
		int locP1 = ccw(p1, node.data.start, node.data.end);
		int locP2 = ccw(p2, node.data.start, node.data.end);
		
		if (locP1 != locP2){
			return node.data;
		} else if (locP1 == CLOCKWISE){
			if (node.rightChild != null){
				return test(node.rightChild, p1, p2);
			} else {
				return null;
			}
		} else if (locP1 == COUNTERCLOCKWISE){
			if (node.leftChild != null){
				return test(node.leftChild, p1, p2);
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
	
	public double avgPathLength(){
		double a = root.extPathLength(root, 0);
		double b = root.countExtNodes(root, 0);
		return a/b;
	}

}