/*
Ermiyas Liyeh
30711570
CSC 172 Online- Summer 2019
I did not collaborate with anyone on this assignment.
*/

public class Node {
	
	public Line data;
	public Node leftChild;
	public Node rightChild;
	public Node parent;
	
	public Node(Line data, Node left, Node right, Node parent){
		this.leftChild = left;
		this.rightChild = right;
		this.parent = parent;
		this.data = data;
	}
	
	public Node(Line data){
		this.data = data;
	}
	
	public Node(Line data, Node parent){
		this.data = data;
		this.parent = parent;
	}
	
	public int countExtNodes(Node node, int count){
			if (this.leftChild!=null){
				count += this.leftChild.countExtNodes(this.leftChild, 0); 
			} else {
				count+=1;
			}
			if (this.rightChild!=null){
				count += this.rightChild.countExtNodes(this.rightChild, 0);
			} else {
				count +=1;
			}
			return count;
	}
	
	public int extPathLength(Node node, int pathLength){
		if (node == null){
			return 0;
		}
		if (node.rightChild == null && node.leftChild == null){
			return pathLength;
		} else {
			return extPathLength(node.leftChild, pathLength+1) + extPathLength(node.rightChild, pathLength+1);
		}
	}

}