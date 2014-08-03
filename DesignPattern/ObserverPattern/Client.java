package ObserverPattern;

/**
 * Autor: jinshuai
 * Date: 2014/8/3
 * Time: 16:48
 */
public class Client {
	public static void main(String[] args){
		Subject subject=new ConcreteSubject();
		Observer observer1=new Observer1();
		Observer observer2=new Observer2();
		subject.add(observer1);
		subject.add(observer2);
		subject.operation();
		subject.del(observer2);
		subject.operation();
		subject.add(observer2);
		subject.operation();
	}
}
/**
 * 场景：
 * RSS订阅deng
 */
