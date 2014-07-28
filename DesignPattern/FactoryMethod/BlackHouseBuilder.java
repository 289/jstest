/**
 * Autor: jinshuai
 * Date: 2014/7/28
 * Time: 21:50
 */
public class BlackHouseBuilder implements HouseFactory {
	@Override
	public House build() {
		System.out.println("Build black house");
		return new BlackHouse();
	}
}
