package FacadePattern;

/**
 * Autor: jinshuai
 * Date: 2014/8/2
 * Time: 17:48
 */
public class PC implements PcFacade{
	private DownSubsystem downSubsystem;
	private PlaySubsystem playSubsystem;
	public PC(DownSubsystem downSubsystem,PlaySubsystem playSubsystem){
		      this.downSubsystem=downSubsystem;
		this.playSubsystem=playSubsystem;
	}
	@Override
	public void watchOnline() {
		downSubsystem.down();
		playSubsystem.paly();
	}
}
