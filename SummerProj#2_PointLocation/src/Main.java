/*
Ermiyas Liyeh
30711570
CSC 172 Online- Summer 2019
I did not collaborate with anyone on this assignment.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static Scanner scanner;
	public static BinaryTree lines;
	
	public static void main(String[] args) throws FileNotFoundException{
		
		lines = new BinaryTree();
		
		Scanner scanner = new Scanner(new File("inputData.txt"));
		
		int num = Integer.parseInt(scanner.nextLine());
		
		for (int i = 0; i<num; i++){
			
			Line line = new Line(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble()); 
			line.lineNum=i;
			lines.insert(line, lines.root);
			
		}
		
		while (scanner.hasNextLine()){
			
			Point p1 = new Point(scanner.nextDouble(), scanner.nextDouble());
			Point p2 = new Point(scanner.nextDouble(), scanner.nextDouble());
			
			System.out.println("Points: "+p1+" & "+p2);
			Line temp = lines.test(lines.root, p1, p2);
			
			if (temp != null){
				System.out.println("Intersected by: "+temp+"\n");
			} else {
				System.out.println("Points in the same region.\n");
			}
		}
		System.out.println(String.format("-------------------------------\n"
				+ "Average Path Length: %.03f", lines.avgPathLength()));
	scanner.close();
	
	}
	
}