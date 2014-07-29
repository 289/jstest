package BuilderPattern;

/**
 * Autor: jinshuai
 * Date: 2014/7/29
 * Time: 23:22
 */
public class Worker implements Builder {
	private boolean haveWindow;
	private boolean haveDoor;
	private boolean haveWall;
	@Override
	public void makeDoor() {
		haveWindow=true;
	}

	@Override
	public void makeWindow() {
		haveDoor=true;
	}

	@Override
	public void makeWall() {
		haveWall=true;
	}

	public House getHouse(){
		if(haveDoor&&haveWall&&haveWindow){
			return new House();
		}
		else{
			return null;
		}
	}
}
