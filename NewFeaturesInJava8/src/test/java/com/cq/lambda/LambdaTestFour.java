/*
方法引用：
若Lambda表达式中的内容有方法已经实现了，可以使用方法引用
可以理解为：方法引用时Lambda表达式的另一种表达形式
主要有三种语法格式：
对象::实例方法名
类::静态方法名
类::实例方法名
注意：
1、Lambda表达式中调用方法的参数列表和返回值类型，要与函数式接口中抽象方法的函数列表和返回值保持一致
2、若Lambda表达式中参数列表中的第一个参数是实例方法的调用者，而第二个参数是实例方法的参数时，可是使用ClassName::methodName

构造器引用、数组引用
 */

package com.cq.lambda;

import com.cq.common.Person;
import org.junit.Test;

import java.util.Comparator;
import java.util.function.*;

public class LambdaTestFour {

	//对象::实例方法名

	@Test
	public void testMethodRefrenceOne() {
		Consumer<String> before = (str) -> System.out.println(str);
		Consumer<String> after = System.out::println;
	}

	@Test
	public void testMethodRefrenceTwo() {
		Person person = new Person(1, "Tom", 18, 333.33);
		Supplier<String> before = () -> person.getName();
		Supplier<String> after = person::getName;
	}

	//类::静态方法名

	@Test
	public void testMethodRefrenceThree() {
		Comparator<Integer> before = (x, y) -> Integer.compare(x, y);
		Comparator<Integer> after = Integer::compareTo;
	}

	//类::实例方法名

	@Test
	public void testMethodRefrenceFour() {
		BiPredicate<String, String> before = (x, y) -> x.equals(y);
		BiPredicate<String, String> after = String::equals;
	}

	//构造器引用

	@Test
	public void testMethodRefrenceFive() {
		Supplier<Person> before = () -> new Person();
		Supplier<Person> after = Person::new;
	}

	@Test
	public void testMethodRefrenceSix() {
		Function<Integer, Person> before = (id) -> new Person(id);
		Function<Integer, Person> after = Person::new;
	}

	@Test
	public void testMethodRefrenceSeven() {
		BiFunction<Integer, Integer, Person> before = (id, age) -> new Person(id, age);
		BiFunction<Integer, Integer, Person> after = Person::new;
	}

	//数组引用

	@Test
	public void testMethodRefrenceEight() {
		Function<Integer, String[]> before = (len) -> new String[len];
		Function<Integer, String[]> after = String[]::new;
	}

}
