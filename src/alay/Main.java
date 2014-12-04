package alay;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

	private LayoutTree layoutTree;
	private String line;
	
	public Main() throws FileNotFoundException {
		readFile("input.txt");
	}
	
	private int getLevel(String line) {
		int ctr = 0;
		for (char ch: line.toCharArray()) {
        	// ASCII TAB CHAR = 9
			if ((int) ch == 9) {
				ctr++;
			}
        }
		return ctr;
	}
	
	public void parse(int ctr, LayoutTree parent, Scanner sc) {
//		System.out.println(line);
//		System.out.println(getLevel(line));
    	while (getLevel(line) == ctr) {    		
    		LayoutTree newChild = new LayoutTree(line.trim());
    		parent.addChildren(newChild);
    		if (sc.hasNextLine()) {
    			line = sc.nextLine();
    			parse(ctr+1, newChild, sc);
    		} else {
    			break;
    		}
    	} 
	}
	
	public void printLayoutTree() {
		print(layoutTree);
	}
	
	public void print(LayoutTree parent) {
		System.out.println(parent);
		System.out.println(parent.getChildren().size());
		for (LayoutTree lt: parent.getChildren()) {
			print(lt);
		}
	}
	
	
	public void readFile(String filename) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader(filename));
		int ctr = 1;
        line = sc.nextLine();
    	layoutTree = new LayoutTree(line);
    	line = sc.nextLine();
    	parse(ctr, layoutTree, sc);
    	printLayoutTree();
        sc.close();
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Main m = new Main();
	}

}
