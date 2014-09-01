package FlyweightPattern;

/**
 * Autor: jinshuai
 * Date: 2014/9/1
 * Time: 22:38
 */
public class ConcreteFlyweight implements Flyweight {
	@Override
	public void operation() {
		System.out.println("Share Object");
	}
}
