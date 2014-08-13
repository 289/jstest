package AdaprerPattern;

/**
 * Autor: jinshuai
 * Date: 2014/8/13
 * Time: 20:54
 */
public class Adapter2 extends Adaptee implements Target {
	@Override
	public void request() {
		super.specificRequest();
	}
}
