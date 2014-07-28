package AbstractFactory;

/**
 * Autor: jinshuai
 * Date: 2014/7/28
 * Time: 22:32
 * 抽象工厂：多个抽象产品类，派生出多个具体产品类；
 * 一个抽象工厂类，派生出多个具体工厂类；
 * 每个具体工厂类可创建多个具体产品类的实例。
 * 即提供一个创建一系列相关或相互依赖对象的接口，而无需指定他们的具体的类。
 * “一对多”的关系。
 * 英文原话
 * "Provide an interface for creating families of related
	 * or dependent objects without specifying their concrete classes",
 * 翻译，“为创建一组相关或相互依赖的对象提供一个借口，无需指定它们的具体类”。
 * 抽象工厂模式通常是用于创一族产品，并且这族产品分不同的等级；
 * 不同的具体工厂类生产不同等级的一族产品。
 */
public class AbstractFactoryTest {
	public static void main(String[] args){
		AnimalFactory animalFactory1=new LittleAnimalBuilder();
		AnimalFactory animalFactory2=new BigAnimalBuilder();
		LandAnimal dog=animalFactory1.getLandAnimal();
		AirAnimal bird=animalFactory1.getAirAnimal();
		LandAnimal cat=animalFactory2.getLandAnimal();
		AirAnimal burrerfly=animalFactory2.getAirAnimal();
		dog.walk();
		bird.fly();

		cat.walk();
		burrerfly.fly();
	}


}
