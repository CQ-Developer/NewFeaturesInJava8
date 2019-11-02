/*
Lambda表达式的基础语法：JAVA8中引入新操作符：->
操作符的左侧：lambda表达式的参数列表
操作符的右侧：lambda表达式的方法体
注意：Lambda表达式需要函数时接口的支持
 */

package com.cq.lambda;

import com.cq.common.Person;
import com.cq.lambda.function.Calculation;
import com.cq.lambda.function.LongFunction;
import com.cq.lambda.function.StringFunction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class LambdaTestTwo {

	//实现java.lang.Runnable.run方法

	public void testLambdaSyntaxOne() {
		Runnable runnable = () -> System.out.println("Hello World");
		runnable.run();
	}

	//实现java.util.function.Consumer.accept方法

	public void testLambdaSyntaxTwo() {
		Consumer<String> consumer = message -> System.out.println(message);
		consumer.accept("Hello World");
	}

	//实现java.util.Comparator.compare方法

	public void testLambdaSyntaxThree() {
		Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
		System.out.println(comparator.compare(5, 6));
	}

	//对整数进行运算
	private Integer operation(Integer x, Calculation<Integer> calculation) {
		return calculation.calculation(x);
	}

	public void testOperation() {
		System.out.println(operation(100, x -> x * x));
		System.out.println(operation(200, x -> x + 50));
	}

	  /*
	  使用java.util.Collections.sort(java.util.List<T>)
	  通过自定义排序比较两个人
	  先按年龄比较，年龄相同按姓名比较
	   */

	public void testComparePerson() {
		List<Person> personList = new ArrayList<>();
		personList.add(new Person(1, "张三", 18, 6999.99));
		personList.add(new Person(2, "李四", 27, 3509.2));
		personList.add(new Person(3, "王五", 21, 4329.54));
		personList.add(new Person(4, "赵六", 36, 8188.12));
		personList.add(new Person(5, "孙七", 48, 14888.88));

		Collections.sort(personList, (x, y) -> {
			if (x.getAge() == y.getAge()) return x.getName().compareTo(y.getName());
			return Integer.compare(x.getAge(), y.getAge());
		});

		personList.forEach(person -> System.out.println(person));
	}

	//用于处理字符串的一个方法
	private String stringHandler(String string, StringFunction myStr) {
		return myStr.stringHandler(string);
	}

	public void testStringUpperCaset() {
		String trimStr = stringHandler("    秋名山车神     ", str -> str.trim());
		System.out.println(trimStr);
		String upperStr = stringHandler("abcdef", string -> string.toUpperCase());
		System.out.println(upperStr);
	}

	//用于对Long类型的数据进行处理
	private void longHandler(Long lng1, Long lng2, LongFunction<Long, Long> functin) {
		System.out.println(functin.getValue(lng1, lng2));
	}

	public void testLongFunction() {
		longHandler(100L, 200L, (x, y) -> x + y);
		longHandler(200L, 300L, (x, y) -> x * y);
	}

}
