package PrototypePattern.CloneTest;

import java.io.Serializable;

/**
 * Autor: jinshuai
 * Date: 2014/8/14
 * Time: 22:12
 */
public class InnerObject implements Serializable {
	private static final long serialVersionUID=1L;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
