/*
终止操作：

收集：
collect：将流转换为其他形式
接收一个Collector接口的实现，用于给stream中元素做汇总的方法
 */

package com.cq.stream;

import com.cq.common.Employee;
import com.cq.common.Status;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTestFive {

	private List<Employee> employeeList = new ArrayList<>();

	@Before
	public void initList() {
		employeeList.add(new Employee(2, "Bbb", 28, 5000.00, Status.BUSY));
		employeeList.add(new Employee(1, "Aaa", 18, 4000.00, Status.FREE));
		employeeList.add(new Employee(4, "Ddd", 48, 7000.00, Status.FREE));
		employeeList.add(new Employee(3, "Ccc", 38, 6000.00, Status.VOCATION));
		employeeList.add(new Employee(6, "Fff", 68, 9000.00, Status.BUSY));
		employeeList.add(new Employee(5, "Eee", 58, 8000.00, Status.VOCATION));
	}

	//将所有员工的名字收集到一个List集合中

	@Test
	public void testStreamAPIOne() {
		List<String> nameList = employeeList.stream().map(Employee::getName).collect(Collectors.toList());
		nameList.forEach(System.out::println);
	}

	//将所有员工的id收集到一个Set集合中

	@Test
	public void testStreamAPITwo() {
		Set<Integer> idSet = employeeList.stream().map(Employee::getId).collect(Collectors.toSet());
		idSet.forEach(System.out::println);
	}

	//将所有员工的年龄收集到一个LinkedList集合中

	@Test
	public void testStreamAPIThree() {
		LinkedList<Integer> ageLinkedList = employeeList.stream().map(Employee::getAge).collect(Collectors.toCollection(LinkedList::new));
		ageLinkedList.forEach(System.out::println);
	}

	//计算所有员工的平均值

	@Test
	public void testStreamAPIFour() {
		Double average = employeeList.stream().collect(Collectors.averagingDouble(Employee::getSalary));
		System.out.println(average);
	}

	//计算所有员工工资的综合

	@Test
	public void testStreamAPIFive() {
		Double sum = employeeList.stream().collect(Collectors.summingDouble(Employee::getSalary));
		System.out.println(sum);
	}

	//找出工资最高的员工

	@Test
	public void testStreamAPISix() {
		Optional<Employee> employee = employeeList.stream().collect(Collectors.maxBy((x, y) -> Double.compare(x.getSalary(), y.getSalary())));
		System.out.println(employee.get());
	}

	//找出最年轻的员工

	@Test
	public void testStreamAPISeven() {
		Optional<Integer> age = employeeList.stream().map(Employee::getAge).collect(Collectors.minBy(Integer::compareTo));
		System.out.println(age.get());
	}

	//将员工按照状态分组

	@Test
	public void testStreamAPIEight() {
		Map<Status, List<Employee>> status = employeeList.stream().collect(Collectors.groupingBy(Employee::getStatus));
		status.entrySet().forEach(System.out::println);
	}

	//多级分组：先按照状态分组，再按照年龄段分组

	@Test
	public void testStreamAPINine() {
		Map<Status, Map<String, List<Employee>>> collect = employeeList.stream().collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy(employee -> {
			Integer age = employee.getAge();
			if (age <= 30) return "青年组";
			if (30 < age && age <= 50) return "中年组";
			if (age > 55) return "老年组";
			return "";
		})));
		collect.entrySet().forEach(System.out::println);
	}

	//分区：按照工资大于7000分区

	@Test
	public void testStreamAPITen() {
		Map<Boolean, List<Employee>> collect = employeeList.stream().collect(Collectors.partitioningBy(employee -> employee.getSalary() > 7000));
		collect.entrySet().forEach(System.out::println);
	}

	//其他一些组函数的获取方式

	@Test
	public void testStreamAPIEleven() {
		DoubleSummaryStatistics collect = employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
		System.out.println(collect.getCount());
		System.out.println(collect.getSum());
		System.out.println(collect.getMax());
		System.out.println(collect.getMin());
		System.out.println(collect.getAverage());
	}

	//将所有员工的名字连接成字符串输出

	@Test
	public void testStreamAPITwelve() {
		String names = employeeList.stream().map(Employee::getName).collect(Collectors.joining(",", "names:[", "]"));
		System.out.println(names);
	}

}
