package ObserverPattern;

/**
 * Autor: jinshuai
 * Date: 2014/8/3
 * Time: 16:39
 */
public interface Subject {
	void add(Observer observer);
	void del(Observer observer);
	void notifyAllObserver();
	void operation();
}
