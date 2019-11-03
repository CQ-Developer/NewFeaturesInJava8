/*
Stream的三个操作步骤
1、创建Stream流
2、中间操作
3、终止操作
 */

package com.cq.stream;

import com.cq.common.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTestOne {

	//创建Stream流

	@Test
	public void TestCreatStreamOne() {
		List<String> list = new ArrayList<>();
		Stream<String> stream = list.stream();
	}

	@Test
	public void TestCreatStreamTwo() {
		Person[] people = new Person[10];
		Stream<Person> stream = Arrays.stream(people);
	}

	@Test
	public void TestCreatStreamThree() {
		Stream<String> stream = Stream.of("a", "b", "c");
	}

	@Test
	public void TestCreatStreamFour() {
		Stream<Integer> stream = Stream.iterate(0, (x) -> x + 2);
		stream.limit(10).forEach(System.out::println);
	}

	@Test
	public void TestCreatStreamFive() {
		Stream<Double> stream = Stream.generate(() -> Math.random());
		stream.limit(5).forEach(System.out::println);
	}

}
