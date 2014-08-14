package PrototypePattern.CloneTest;

import java.io.IOException;

/**
 * Autor: jinshuai
 * Date: 2014/8/14
 * Time: 22:13
 *
 * Cloneable 是克隆接口，复制功能只能浅复制，克隆对象里面的对象还是同一个对象
 */
public class Client {
	public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
		Prototype prototype=new Prototype();
		prototype.setInnerObject(new InnerObject());
		prototype.getInnerObject().setName("inner");
		prototype.setName("outter");
		Prototype prototype1= (Prototype) prototype.clone();
//		test1(prototype,prototype1);
		test2(prototype);
	}

	private static void test2(Prototype prototype) throws IOException, ClassNotFoundException {
		  Prototype prototype1= (Prototype) prototype.deepClone();
		prototype1.getInnerObject().setName("change name");
		 System.out.println(prototype1.getName());
		 System.out.println(prototype1.getInnerObject().getName());
		 System.out.println("///////////");
		 System.out.println(prototype.getInnerObject().getName());
	}

	private static void test1(Prototype prototype,Prototype prototype1){
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
