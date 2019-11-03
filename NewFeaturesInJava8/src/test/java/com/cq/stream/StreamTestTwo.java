/*
Stream的三个操作步骤
1、创建Stream流
2、中间操作
3、终止操作

常用中间操作：筛选与切片
1、filter：过滤
2、limit：截取
3、skip：跳过
4、distinct：去重
5、map：映射
6、flatMap：流连接
7、sorted：排序
 */

package com.cq.stream;

import com.cq.common.Person;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTestTwo {

	private List<Person> personList = new ArrayList<>();

	@Before
	public void initList() {
		personList.add(new Person(1, "张三", 18, 6999.99));
		personList.add(new Person(2, "李四", 27, 3509.2));
		personList.add(new Person(3, "王五", 51, 4329.54));
		personList.add(new Person(4, "赵六", 36, 8188.12));
		personList.add(new Person(5, "孙七", 48, 14888.88));
		personList.add(new Person(5, "孙七", 48, 14888.88));
		personList.add(new Person(5, "孙七", 48, 14888.88));
	}

	//过滤掉年龄小于35的人

	@Test
	public void testStreamAPIOne() {
		personList.stream().filter(person -> person.getAge() > 35).forEach(System.out::println);
	}

	//过滤掉工资小于4000的人，取前三个

	@Test
	public void testStreamAPITwo() {
		personList.stream().filter(person -> person.getSalary() > 4000).limit(3).forEach(System.out::println);
	}

	//过滤掉工资小于4000的人，不取前三个

	@Test
	public void testStreamAPIThree() {
		personList.stream().filter(person -> person.getSalary() > 4000).skip(3).forEach(System.out::println);
	}

	//过滤掉年龄小于40岁的，并去掉重复的人

	@Test
	public void testStreamAPIFour() {
		personList.stream().filter(person -> person.getAge() > 40).distinct().forEach(System.out::println);
	}

	//获取所有人的工资,并打印

	@Test
	public void testStreamAPIFive() {
		personList.stream().map(Person::getSalary).forEach(System.out::println);
	}

	//将字符串中的所有字符添加到一个新的集合中，以流的形式返回

	private static Stream<Character> filterCharacter(String str) {
		List<Character> list = new ArrayList<>();
		for (char c : str.toCharArray()) {
			list.add(c);
		}
		return list.stream();
	}

	@Test
	public void testStreamAPISix() {
		List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd");
		list.stream().flatMap(StreamTestTwo::filterCharacter).forEach(System.out::println);
	}

	//先按照年龄排序，年龄相同按照姓名排序

	@Test
	public void testStreamAPISeven() {
		personList.stream().sorted((p1, p2) -> {
			if (p1.getAge().equals(p2.getAge())) return p1.getName().compareTo(p2.getName());
			return p1.getAge().compareTo(p2.getAge());
		}).forEach(System.out::println);
	}

}
