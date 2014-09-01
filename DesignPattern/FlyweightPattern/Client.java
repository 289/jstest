package FlyweightPattern;

/**
 * Autor: jinshuai
 * Date: 2014/9/1
 * Time: 22:41
 * flyweight pattern 又称享元模式
	Use sharing to support large numbers
	of fine-grained objects efficiently --- GoF
	运用共享技术有效地支持大量细粒度的对象
 */

public class Client {
	public static void main(String[] args) {
		Flyweight flyweight=new FlyweightFactory().getFlyweight();
		flyweight.operation();
	}
}
