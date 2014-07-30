package CommandPattern;

/**
 * Autor: jinshuai
 * Date: 2014/7/30
 * Time: 23:38
 */
public class Invoker {
	public Command[] command;
	public Invoker(Command ...command){
		this.command=command;
	}
	public void action(){
		if(command!=null){
			for(Command c:command){
				c.execute();
			}
		}
	}
}
