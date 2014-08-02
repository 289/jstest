/**
 * Autor: jinshuai
 * Date: 2014/7/28
 * Time: 21:27
 * 工厂方法：一抽象产品类派生出多个具体产品类；一抽象工厂类派生出多个具体工厂类；
 * 			每个具体工厂类只能创建一个具体产品类的实例。
 * 			即定义一个创建对象的接口（即抽象工厂类），
 * 			让其子类（具体工厂类）决定实例化哪一个类（具体产品类）。“一对一”的关系。
 *
 * 	工厂方法模式（Factory Method Pattern），是简单工厂模式的扩展，
 * 	其英文原话是
 * 	"Define an interface for creating an object,
 * 	but let the subclasses decide which class to instantiate.
 * 	Factory Method lets a class defer instantiation to subclasses"，
 * 	翻译是：定义一个创建对象的接口，但是让子类来觉得该实例化那个类。
 * 	工厂方法让一个类推迟实例化至它的子类中。
 */
public class Client {
	public static void main(String[] args){
		HouseFactory houseFactory1=new WhiteHouseBuilder();
		HouseFactory houseFactory2=new BlackHouseBuilder();
		House house1= houseFactory1.build();
		House house2= houseFactory2.build();
		house1.live();
		house2.live();
	}
}
/**
 * 运行结果：
 * Build white house
 * Build black house
 * Live in white house
 * Live in black house
 */
