package AbstractFactory;

/**
 * Autor: jinshuai
 * Date: 2014/7/28
 * Time: 22:23
 */
abstract class AnimalFactory {
	abstract LandAnimal getLandAnimal();
	abstract AirAnimal getAirAnimal();
}
