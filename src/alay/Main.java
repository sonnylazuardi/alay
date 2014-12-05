package alay;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	private LayoutTree layoutTree;
	private String line;
	
	public Main() throws IOException {
		readFile("input.txt");
	}
	
	public void generateXML() throws IOException {
		String content = "";
		content += "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n";
		
		content += layoutTree.toString();
		File file = new File("output.txt");

		// if file doesnt exists, then create it
		if (!file.exists()) {
			file.createNewFile();
		}

		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(content);
		bw.close();

		System.out.println("Done");
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
	
	public void readFile(String filename) throws IOException {
		Scanner sc = new Scanner(new FileReader(filename));
		int ctr = 1;
        line = sc.nextLine();
    	layoutTree = new LayoutTree(line);
    	line = sc.nextLine();
    	parse(ctr, layoutTree, sc);
    	generateXML();
        sc.close();
	}
	
	public static void main(String[] args) throws IOException {
		Main m = new Main();
	}

}
