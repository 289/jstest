package ProxyPattern;

/**
 * Autor: jinshuai
 * Date: 2014/8/6
 * Time: 22:33
 */
public class RealSubject implements Subject {
	@Override
	public void request() {
		System.out.println("Real subject");
	}
}
