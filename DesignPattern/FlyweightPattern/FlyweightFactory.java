package FlyweightPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Autor: jinshuai
 * Date: 2014/9/1
 * Time: 22:35
 */
public class FlyweightFactory {
	public FlyweightFactory() {
		for (int i = 0; i < 10; i++) {
		  flyweightList.add(new ConcreteFlyweight());
		}
	}
	private  List<Flyweight> flyweightList=new ArrayList<Flyweight>();

	public  Flyweight getFlyweight(){
		return flyweightList.get(0);
	}
}
