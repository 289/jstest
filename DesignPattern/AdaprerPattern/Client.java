package AdaprerPattern;

/**
 * Autor: jinshuai
 * Date: 2014/8/13
 * Time: 20:55
 *
 * “Convert the interface of a class into another interface clients expect.
 * Adapter lets classes work together that couldn’t otherwise because of
 * incompatible interfaces.” ---GoF
 *
	将一个类的接口转化为客户端所期望的接口。
	适配器模式使得原本拥有不兼容接口的类能一起“工作”。--GoF

 */
public class Client {
	public static void main(String[] args){
		Target target=new Adapter(new Adaptee());
		Target target2=new Adapter2();
		target.request();
		target2.request();
	}
}

/**
 * 4.应用场景

 在以下各种情况下使用适配器模式：

 1．系统需要使用现有的类，而此类的接口不符合系统的需要。

 2．想要建立一个可以重复使用的类，用于与一些彼此之间没有太大关联的一些类，
 。这些源类不一定有很复杂的接口。

 3．（对对象适配器而言）在设计里，需要改变多个已有子类的接口，
 如果使用类的适配器模式，就要针对每一个子类做一个适配器，而这不太实际。
 */
