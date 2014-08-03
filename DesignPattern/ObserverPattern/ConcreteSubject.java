package ObserverPattern;

/**
 * Autor: jinshuai
 * Date: 2014/8/3
 * Time: 16:47
 */
public class ConcreteSubject extends AbstractSubject {
	@Override
	public void operation() {
		System.out.println("Update something");
		super.notifyAllObserver();
	}
}
