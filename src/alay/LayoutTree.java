package alay;

import java.util.ArrayList;

public class LayoutTree {
	private ArrayList <LayoutTree> children = new ArrayList<LayoutTree>();
	private String type;
	
	private ArrayList <Attribute> attributes =  new ArrayList<Attribute>();
	
	public LayoutTree(String line) {
		if (line.contains(" -> ")) {
			String[] splitter = line.split(" -> ");
			this.type = splitter[0];
			String[] splitter2 = splitter[1].split(", ");
			for (String temp : splitter2) {
				String[] splitter3 = temp.split(":");
				Attribute att1 = new Attribute(splitter3[0], splitter3[1]);
				this.attributes.add(att1);
			}
		} else {
			this.type = line;
		}
	}
	public ArrayList<LayoutTree> getChildren() {
		return children;
	}
	public String toString() {
		String temp = "";
		temp += this.type;
		temp += " (";
		for (Attribute att : this.attributes) {
			temp += att.getKey() + " : " + att.getValue();
			temp += ", ";
		}
		temp += ")";
		return temp;
	}
	
	public void setChildren(ArrayList<LayoutTree> children) {
		this.children = children;
	}
	public void addChildren(LayoutTree child) {
		this.children.add(child);
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public ArrayList<Attribute> getAttributes() {
		return attributes;
	}
	public void setAttributes(ArrayList<Attribute> attributes) {
		this.attributes = attributes;
	}
	
}
