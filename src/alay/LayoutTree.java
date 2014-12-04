package alay;

import java.util.ArrayList;

public class LayoutTree {
	private ArrayList <LayoutTree> children;
	private String type;
	private ArrayList <Attribute> attributes;
	public ArrayList<LayoutTree> getChildren() {
		return children;
	}
	public void setChildren(ArrayList<LayoutTree> children) {
		this.children = children;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public LayoutTree(ArrayList<LayoutTree> children, String type,
			ArrayList<Attribute> attributes) {
		super();
		this.children = children;
		this.type = type;
		this.attributes = attributes;
	}
	public ArrayList<Attribute> getAttributes() {
		return attributes;
	}
	public void setAttributes(ArrayList<Attribute> attributes) {
		this.attributes = attributes;
	}
	
}
