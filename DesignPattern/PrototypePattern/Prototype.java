package PrototypePattern;

/**
 * Autor: jinshuai
 * Date: 2014/8/14
 * Time: 23:32
 */
public class Prototype implements Cloneable {
	@Override
	public Prototype clone()  {
		Prototype prototype= null;
		try {
			prototype = (Prototype) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return prototype;
	}
}
