/**
 * Autor: jinshuai
 * Date: 2014/7/22
 * Time: 20:58
 */
public class Three {
	private static Three three;
	private Three(){}
	private static class InstanceClass{
		private static Three instance=new Three();
	}
	public static Three getInstance(){
		return InstanceClass.instance;
	}
}
