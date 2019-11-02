package com.cq.lambda;

import com.cq.common.Person;
import com.cq.lambda.function.MyPredicate;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LambdaTestOne {

	private List<Person> personList = new ArrayList<>();

	@Before
	public void generateList() {
		personList.add(new Person(1, "张三", 18, 6999.99));
		personList.add(new Person(2, "李四", 27, 3509.2));
		personList.add(new Person(3, "王五", 21, 4329.54));
		personList.add(new Person(4, "赵六", 36, 8188.12));
		personList.add(new Person(5, "孙七", 48, 14888.88));
	}

	//使用匿名内部类的模式实现策略模式
	private List<Person> filterPersonList(List<Person> list, MyPredicate<Person> predicate) {
		List<Person> newList = new ArrayList<>();
		for (Person person : list) {
			if (predicate.test(person)) newList.add(person);
		}
		return newList;
	}

	//需求：获取年龄大于35的人的信息

	@Test
	public void testInnerClassDemoAge() {
		List<Person> list = filterPersonList(this.personList, new MyPredicate<Person>() {
			@Override
			public boolean test(Person person) {
				return person.getAge() > 35;
			}
		});
		for (Person person : list) {
			System.out.println(person);
		}
	}

	//需求：获取工资大于5000的人的信息

	@Test
	public void testInnerClassDemoSalary() {
		List<Person> list = filterPersonList(this.personList, new MyPredicate<Person>() {
			@Override
			public boolean test(Person person) {
				return person.getSalary() > 5000;
			}
		});
		for (Person person : list) {
			System.out.println(person);
		}
	}

	//使用lambda表达式的方式优化代码

	@Test
	public void testLambdaDemoAge() {
		List<Person> list = filterPersonList(this.personList, person -> person.getAge() > 35);
		list.forEach(person -> System.out.println(person));
	}

	@Test
	public void testLambdaDemoSalary() {
		List<Person> list = filterPersonList(this.personList, person -> person.getSalary() > 5000);
		list.forEach(person -> System.out.println(person));
	}

}
