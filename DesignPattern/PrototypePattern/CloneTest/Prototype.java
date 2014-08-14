package PrototypePattern.CloneTest;

import java.io.*;

/**
 * Autor: jinshuai
 * Date: 2014/8/14
 * Time: 22:11
 */
public class Prototype implements Cloneable,Serializable {
	private static final long serialVersionUID=1L;
	private InnerObject innerObject;
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
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public Object deepClone() throws IOException, ClassNotFoundException {
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
		ObjectOutputStream oos=new ObjectOutputStream(bos);
		oos.writeObject(this);

		ByteArrayInputStream bis=new ByteArrayInputStream(bos.toByteArray());
		ObjectInputStream  ois= new ObjectInputStream(bis);
		return ois.readObject();
	}
}
