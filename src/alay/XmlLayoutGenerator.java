package alay;

public class XmlLayoutGenerator {
	private LayoutTree layoutTree;
	private String xmlLayout;

	public String getXmlLayout() {
		return xmlLayout;
	}

	public void setXmlLayout(String xmlLayout) {
		this.xmlLayout = xmlLayout;
	}

	public LayoutTree getLayoutTree() {
		return layoutTree;
	}

	public void setLayoutTree(LayoutTree layoutTree) {
		this.layoutTree = layoutTree;
	}

	public XmlLayoutGenerator(LayoutTree layoutTree) {
		super();
		this.layoutTree = layoutTree;
	}
	
	public void generate() {
		String result = "";
		
		xmlLayout = result;
	}

}
