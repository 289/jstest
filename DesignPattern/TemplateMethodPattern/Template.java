package TemplateMethodPattern;

/**
 * Autor: jinshuai
 * Date: 2014/8/5
 * Time: 22:54
 */
public abstract class Template {
	void templateMethod(){
		primitiveMethod1();
		primitiveMethod2();
		concreteMethod();
	}

	public abstract void primitiveMethod1();
	public abstract void primitiveMethod2();

	final void concreteMethod(){
		System.out.print("algorithm content");
	}
}
