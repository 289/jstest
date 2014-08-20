package CompositePattern;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Autor: jinshuai
 * Date: 2014/8/20
 * Time: 23:32
 *
 * “Compose objects into tree structures to represent part-whole hierarchies.
 * Composite lets clients treat individual objects
 * and compositions of objects uniformly.” – GoF
 *
 *整体与部分统一对待
 */
public abstract class Component {
	public abstract void operation();
	public abstract void add(Component component);
	public abstract void remove(Component component);
	public abstract ConcurrentLinkedQueue<Component> getChildren();
}
