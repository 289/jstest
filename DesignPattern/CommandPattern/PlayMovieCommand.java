package CommandPattern;


/**
 * Autor: jinshuai
 * Date: 2014/7/30
 * Time: 23:35
 */
public class PlayMovieCommand implements Command {
	private PcReceiver receiver;
	public PlayMovieCommand(PcReceiver receiver){
		 this.receiver=receiver;
	}
	@Override
	public void execute() {
		 receiver.playMovie();
	}
}
