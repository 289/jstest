package CompositePattern;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Autor: jinshuai
 * Date: 2014/8/20
 * Time: 23:52
 */
public class Leaf extends Component {
	@Override
	public void operation() {
		System.out.println("I don't have children");
	}

	@Override
	public final void add(Component component) {
		  throw new UnsupportedOperationException("不支持此操作");
	}

	@Override
	public void remove(Component component) {
		throw new UnsupportedOperationException("不支持此操作");
	}

	@Override
	public ConcurrentLinkedQueue<Component> getChildren() {
		throw new UnsupportedOperationException("不支持此操作");
	}
}
