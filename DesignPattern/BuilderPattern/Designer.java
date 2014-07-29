package BuilderPattern;

/**
 * Autor: jinshuai
 * Date: 2014/7/29
 * Time: 23:11
 */
public class Designer {
	private Builder builder;
	public Designer(){
	}
	public Designer(Builder builder){
		this.builder=builder;
	}

	public void makeHouse() {
		builder.makeDoor();
		builder.makeWindow();
		builder.makeWall();
	}
}
