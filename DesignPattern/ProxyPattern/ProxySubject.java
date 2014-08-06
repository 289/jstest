package ProxyPattern;

/**
 * Autor: jinshuai
 * Date: 2014/8/6
 * Time: 22:34
 */
public class ProxySubject implements Subject {
	private Subject realSubject;
	public ProxySubject(Subject subject){
		 realSubject=subject;
	}
	@Override
	public void request() {
		realSubject.request();
	}
}
