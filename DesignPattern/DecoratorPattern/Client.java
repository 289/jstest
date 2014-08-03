package DecoratorPattern;

/**
 * Autor: jinshuai
 * Date: 2014/8/3
 * Time: 15:24
 * 动态将职责附加到对象上，若要扩展功能，装饰者提供了比继承更具弹性的代替方案。
 * 它是通过创建一个包装对象，也就是装饰来包裹真实的对象。
 * [由于继承的静态特质使其缺乏灵活性；且随着子类的增多、组合，会导致更多子类的膨胀。
 * 类应设计的对扩展开放，对修改关闭。装饰的意思：就是包装一下。把另的对象包装一下。]
 */
public class Client {
	public static void main(String[] args){
		Component component=new ConcreteComponent();
		Decorator decorator=new ConcreteDecorator(component);
		decorator.action();
	}
}

/**
 * 应用场景
 1）需要扩展一个类的功能，或给一个类增加附加责任。
 2）需要动态地给一个对象增加功能，这些功能可以再动态地撤销。
 3）需要增加由一些基本功能的排列组合而产生的非常大量的功能，从而使继承关系变得不现实。
 */
