package ObserverPattern;

/**
 * Autor: jinshuai
 * Date: 2014/8/3
 * Time: 16:39
 */
public class Observer2 implements Observer {
	@Override
	public void update() {
		System.out.println("Observer2 has update");
	}
}
