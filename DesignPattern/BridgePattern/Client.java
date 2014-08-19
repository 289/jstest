package BridgePattern;

/**
 * Autor: jinshuai
 * Date: 2014/8/19
 * Time: 22:27
 * 意图：
 将抽象部分与它的实现部分分离，使它们都可以独立地变化。
 */
public class Client {
	public static void main(String[] args){
		Abstraction operator=new RefinedAbstraction();
		Implementor implementor1=new ConreteImplementorA();
		Implementor implementor2=new ConcreteImplementorB();
		operator.setImplementor(implementor1);
		operator.operation();
		operator.setImplementor(implementor2);
		operator.operation();
	}
}
