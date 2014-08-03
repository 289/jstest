package ObserverPattern;

/**
 * Autor: jinshuai
 * Date: 2014/8/3
 * Time: 16:38
 */
public class Observer1 implements Observer {
	@Override
	public void update() {
		System.out.println("Observer1 has update");
	}
}
