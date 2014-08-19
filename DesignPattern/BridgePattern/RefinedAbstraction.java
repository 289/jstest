package BridgePattern;

/**
 * Autor: jinshuai
 * Date: 2014/8/19
 * Time: 22:21
 */
public class RefinedAbstraction extends Abstraction {
	@Override
	public void operation() {
		super.getImplementor().operationImp();
	}
}
