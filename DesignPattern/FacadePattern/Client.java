package FacadePattern;

/**
 * Autor: jinshuai
 * Date: 2014/8/2
 * Time: 17:50
 * 英文：
 * Provide a unified interface to a set of interfaces in a subsystem.
 * Facade defines a higher-level interface
 * that makes the subsystem easier to use--GoF
 * 为子系统中的一组接口提供一个统一接口。
 * Facade模式定义了一个高层接口，这个接口使得这子系统更容易使用。
 */
public class Client {
	public static void main(String[] args){
		PcFacade pc=new PC(new DownSubsystem(),new PlaySubsystem());
		pc.watchOnline();
	}
}
