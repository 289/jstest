package DecoratorPattern;

/**
 * Autor: jinshuai
 * Date: 2014/8/3
 * Time: 15:11
 */
public abstract class Decorator implements Component{
	private Component component;
	public Decorator(Component component){
		  this.component=component;
	}

	public void action() {
		 component.action();
	}
}
