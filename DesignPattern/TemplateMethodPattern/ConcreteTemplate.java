package TemplateMethodPattern;


/**
 * Autor: jinshuai
 * Date: 2014/8/5
 * Time: 23:03
 */
public class ConcreteTemplate extends Template {
	@Override
	public void primitiveMethod1() {
		System.out.println("Prepare something");
	}

	@Override
	public void primitiveMethod2() {
		System.out.println("Prepare other things");
	}
}
