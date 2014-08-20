package CompositePattern;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Autor: jinshuai
 * Date: 2014/8/20
 * Time: 23:33
 */
public class Composite extends Component {
//	private List<Component> children=new Vector<Component>();
	private ConcurrentLinkedQueue<Component> children= new ConcurrentLinkedQueue<Component>();
	@Override
	public void operation() {
		System.out.println("I have children");
	}

	@Override
	public void add(Component component) {
		children.add(component);
	}

	@Override
	public void remove(Component component) {
		        children.remove(component);
	}

	@Override
	public ConcurrentLinkedQueue<Component> getChildren() {
		return children;
	}
}
