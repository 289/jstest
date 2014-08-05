package TemplateMethodPattern;

/**
 * Autor: jinshuai
 * Date: 2014/8/5
 * Time: 23:04
 * 英文：
 * The Template Method Pattern defines the skeleton of an algorithm in a method,
 * deferring some steps to subclasses.
 * Template Method lets subclasses redefine certain steps
 * of an algorithm without changing the algorithm's structure.
 * 概念：定义一个算法的骨架，而将一些实现步骤延迟到子类中。
 　　　　把不变的行为搬到超类，去除子类中重复的代码来体现他的优势。
 4.应用场景：
 1) 一次性实现一个算法的不变的部分，并将可变的行为留给子类来实现。
 2) 各子类中公共的行为应被提取出来并集中到一个公共父类中以避免代码重复。
 	首先识别现有代码中的不同之处，并且将不同之处分离为新的操作。
	 最后，用一个调用这些新的操作的模板方法来替换这些不同的代码。
 */
public class Client {
	public static void main(String[] args){
		Template template=new ConcreteTemplate();
		template.templateMethod();
	}
}

/**
 * Template Method Pattern 概要：

 Ø         A "template method" defines the steps of an algorithm, deferring to subclasses for the implementation of those steps.

 Ø         The Template Method gives up an important technique for code reuse.

 Ø         The template method's abstract class may define concrete classes, abstract classes and hooks.

 Ø         Abstract methods are implemented by subclasses.

 Ø         Hooks are methods that do nothing or default behavior in the abstract classes, but may be overridden in the subclass.

 Ø         To prevent subclasses from changing the algorithm in the template method, declare the template method as final.

 Ø         The Hollywood Principle guides us to put decision-making in high-level modules that can decide how and when to call low-level modules.

 Ø         You'll see lots of uses of the Template Method Pattern in real world code, but don't expect it all (like any pattern) to be designed "by the book".

 Ø         The strategy and Template Method Patterns both encapsulate algorithms, one by inheritance and one by composition.

 Ø         The Factory Method pattern is a specialization of Template Method.
 */
