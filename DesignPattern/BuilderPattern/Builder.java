package BuilderPattern;

/**
 * Autor: jinshuai
 * Date: 2014/7/29
 * Time: 23:12
 */
public interface Builder {
	public void makeDoor();

	public void makeWindow();

	public void makeWall();

	public House getHouse();
}
