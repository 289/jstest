package CloneTest;

/**
 * Autor: jinshuai
 * Date: 2014/8/14
 * Time: 22:11
 */
public class Prototype implements Cloneable{
	private InnerObject  innerObject;
	private String name;

	public InnerObject getInnerObject() {
		return innerObject;
	}

	public void setInnerObject(InnerObject innerObject) {
		this.innerObject = innerObject;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
