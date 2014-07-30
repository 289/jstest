package CommandPattern;

/**
 * Autor: jinshuai
 * Date: 2014/7/30
 * Time: 23:27
 */
public class TurnOnCommand implements Command {
	private PcReceiver receiver;
	public TurnOnCommand(PcReceiver receiver){
		  this.receiver=receiver;
	}
	@Override
	public void execute() {
		 receiver.turnOn();
	}
}
