/**
 * Autor: jinshuai
 * Date: 2014/7/22
 * Time: 20:48
 */
public class Two {
	/*这里要用static，保证实例与对象无关*/
	private static Two two=new Two();
	private Two(){}
	public static Two getInstance(){
		return two;
	}
}
