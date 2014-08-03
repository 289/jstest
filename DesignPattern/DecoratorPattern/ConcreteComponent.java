package DecoratorPattern;

/**
 * Autor: jinshuai
 * Date: 2014/8/3
 * Time: 15:10
 */
public class ConcreteComponent implements Component {
	@Override
	public void action() {
		System.out.println("Do something");
	}
}
