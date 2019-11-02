/*
Java8中内置的四大核心函数式接口

消费型接口：java.util.function.Consumer
方法：void accept(T t)

供给型接口：java.util.function.Supplier
方法：T get()

函数型接口：java.util.function.Function
方法：R apply(T t)

断言型接口：java.util.function.Predicate
方法：boolean test(T t)
 */

package com.cq.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaTestThree {

	//消费型接口应用
	private void spend(double money, Consumer<Double> consumer) {
		consumer.accept(money);
	}

	public void testConsumer() {
		spend(10000, money -> System.out.println("本次消费" + money + "元"));
	}

	//供给型接口应用
	private List<Integer> getIntegerList(int len, Supplier<Integer> supplier) {
		List<Integer> list = new ArrayList<>(len);
		for (int i = 0; i < len; i++) {
			Integer num = supplier.get();
			list.add(num);
		}
		return list;
	}

	public void testSupplier() {
		List<Integer> list = getIntegerList(10, () -> (int) (Math.random() * 100));
		System.out.println(list);
	}

	//函数型接口应用
	private String strHandler(String str, Function<String, String> function) {
		return function.apply(str);
	}

	public void testFunction() {
		String newStr = strHandler("   i like china   ", str -> str.trim().toUpperCase());
		System.out.println(newStr);
	}

	//断言型接口应用
	private List<String> strFilter(List<String> strList, Predicate<String> predicate) {
		List<String> list = new ArrayList<>();
		for (String str : strList)
			if (predicate.test(str)) list.add(str);
		return list;
	}

	public void testPredicate() {
		List<String> list = Arrays.asList("hello", "hahah", "nanjing", "a", "cq");
		List<String> newList = strFilter(list, str -> str.length() < 3);
		System.out.println(newList);
	}

}
