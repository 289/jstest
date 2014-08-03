package DecoratorPattern;

/**
 * Autor: jinshuai
 * Date: 2014/8/3
 * Time: 15:22
 */
public class ConcreteDecorator extends Decorator {
	public ConcreteDecorator(Component component) {
		super(component);
	}

	@Override
	public void action() {
		super.action();
		addBehavior();
	}

	private void addBehavior() {
		System.out.println("");
	}
}
