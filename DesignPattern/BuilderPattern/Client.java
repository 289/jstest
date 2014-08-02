package BuilderPattern;

/**
 * Autor: jinshuai
 * Date: 2014/7/29
 * Time: 23:29
 * 建造者模式
 * 英文：
 * Separate the construction of a complex object from its
 * representation so that the same construction process
 * can create different representations.
 * Builder设计模式，提供一种封装机制来隔离出构成复杂对象的各个子对象的变化，
 * 从而保持系统中的相对稳定的将这些子对象组合在一起的算法不随着需求的改变而改变
 */
public class Client {
	public static void main(String[] args){
		Builder builder=new Worker();
		Designer designer=new Designer(builder);
		designer.makeHouse();
		House house=builder.getHouse();
		house.liveIn();
	}
}
