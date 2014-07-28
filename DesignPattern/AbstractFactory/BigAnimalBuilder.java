package AbstractFactory;

/**
 * Autor: jinshuai
 * Date: 2014/7/28
 * Time: 22:31
 */
public class BigAnimalBuilder extends AnimalFactory {

	@Override
	LandAnimal getLandAnimal() {
		System.out.println("Build dog");
		return new Dog();
	}

	@Override
	AirAnimal getAirAnimal() {
		System.out.println("Build bird");
		return new Bird();
	}
}
