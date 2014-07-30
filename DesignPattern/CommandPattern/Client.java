package CommandPattern;

/**
 * Autor: jinshuai
 * Date: 2014/7/30
 * Time: 23:37
 * 英文：
 * “Encapsulate a request as an object,
 * thereby letting you parameterize clients with different requests,
 * queue or log requests, and support undoable operations.” – GoF
 *
 * 将一个请求封装为一个对象，
 * 从而可用不同的请求(一个被封装成了对象的请求)对客户程序(即调用者)进行参数化；
 * 对请求排队或记录请求日志，以及支持可撤销的操作。
 */
public class Client {
	public static void main(String[] args){
		PcReceiver pcReceiver=new PcReceiver();
		Command turnOnCommand=new TurnOnCommand(pcReceiver);
		Command playMovieCommand=new PlayMovieCommand(pcReceiver);
		Invoker invoker=new Invoker(turnOnCommand,playMovieCommand);
		invoker.action();
	}
}
