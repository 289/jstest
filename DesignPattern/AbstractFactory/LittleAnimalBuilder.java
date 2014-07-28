package AbstractFactory;

/**
 * Autor: jinshuai
 * Date: 2014/7/28
 * Time: 22:31
 */
public class LittleAnimalBuilder extends AnimalFactory
{
	@Override
	LandAnimal getLandAnimal() {
		System.out.println("Build cat");
		return new Cat();
	}

	@Override
	AirAnimal getAirAnimal() {
		System.out.println("Build butterfly");
		return new Butterfly();
	}
}
