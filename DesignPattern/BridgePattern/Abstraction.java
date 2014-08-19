package BridgePattern;

/**
 * Autor: jinshuai
 * Date: 2014/8/19
 * Time: 22:18
 */
public abstract class Abstraction{
	private Implementor implementor;
	public void operation(){
		implementor.operationImp();
	};

	public Implementor getImplementor() {
		return implementor;
	}

	public void setImplementor(Implementor implementor) {
		this.implementor = implementor;
	}
}
