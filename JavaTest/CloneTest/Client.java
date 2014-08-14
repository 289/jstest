package CloneTest;

/**
 * Autor: jinshuai
 * Date: 2014/8/14
 * Time: 22:13
 *
 * Cloneable 是克隆接口，复制功能只能浅复制，克隆对象里面的对象还是同一个对象
 */
public class Client {
	public static void main(String[] args) throws CloneNotSupportedException {
		Prototype prototype=new Prototype();
		prototype.setInnerObject(new InnerObject());
		prototype.getInnerObject().setName("inner");
		prototype.setName("outter");
		Prototype prototype1= (Prototype) prototype.clone();
		System.out.println(prototype.getName());
		System.out.println(prototype.getInnerObject().getName());
		System.out.println("-------");
		System.out.println(prototype1.getName());
		System.out.println(prototype1.getInnerObject().getName());
		prototype1.setName("change out name");
		prototype1.getInnerObject().setName("change innerobject name");
		System.out.println("****************");
		System.out.println(prototype.getName());
		System.out.println(prototype.getInnerObject().getName());
		System.out.println("-------");
		System.out.println(prototype1.getName());
		System.out.println(prototype1.getInnerObject().getName());
	}

}
