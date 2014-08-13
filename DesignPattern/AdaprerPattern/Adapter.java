package AdaprerPattern;

/**
 * Autor: jinshuai
 * Date: 2014/8/13
 * Time: 20:53
 */
public class Adapter implements Target {
	private Adaptee adaptee;
	public Adapter(Adaptee adaptee){
		   this.adaptee=adaptee;
	}
	@Override
	public void request() {
		adaptee.specificRequest();
	}
}
