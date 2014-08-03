package ObserverPattern;

import java.util.List;
import java.util.Vector;

/**
 * Autor: jinshuai
 * Date: 2014/8/3
 * Time: 16:43
 */
public abstract class AbstractSubject implements Subject {
	private List<Observer> observers = new Vector<Observer>();
	@Override
	public void add(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void del(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyAllObserver() {
		for(Observer o:observers){
			 o.update();
		}
	}

//	@Override
//	public void operation() {
//
//	}
}
