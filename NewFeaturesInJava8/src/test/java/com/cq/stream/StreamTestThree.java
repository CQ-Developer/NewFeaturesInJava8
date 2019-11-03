/*
终止操作：

查找与匹配
allMatch：检查是否匹配所有元素
anyMatch：检查是否匹配一个元素
noneMatch：检查是否没有匹配的元素
findFirst：返回第一个元素
findAny：返回任意元素
count：返回元素的总个数
max：返回最大值
min：返回最小值
 */

package com.cq.stream;

import com.cq.common.Employee;
import com.cq.common.Status;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StreamTestThree {

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

	//判断所有员工是否处于忙碌状态

	@Test
	public void testStreamAPIOne() {
		boolean allMatch = employeeList.stream().allMatch(employee -> Status.BUSY.equals(employee.getStatus()));
		System.out.println(allMatch);
	}

	//判断是否有员工处于忙碌状态

	@Test
	public void testStreamAPITwo() {
		boolean anyMatch = employeeList.stream().anyMatch(employee -> Status.BUSY.equals(employee.getStatus()));
		System.out.println(anyMatch);
	}

	//判断是否所有员工都不处于忙碌状态

	@Test
	public void testStreamAPIThree() {
		boolean noneMatch = employeeList.stream().noneMatch(employee -> Status.BUSY.equals(employee.getStatus()));
		System.out.println(noneMatch);
	}

	//按照工资有小到大排序，取第一个元素

	@Test
	public void testStreamAPIFour() {
		Optional<Employee> first = employeeList.stream().sorted((x, y) -> Double.compare(x.getSalary(), y.getSalary())).findFirst();
		System.out.println(first.get());
	}

	//随便找出一个处于空闲状态的人

	@Test
	public void testStreamAPIFive() {
		Optional<Employee> any = employeeList.parallelStream().filter(employee -> Status.FREE.equals(employee.getStatus())).findAny();
		System.out.println(any.get());
	}

	//找出处于休假状态的人有几个

	@Test
	public void testStreamAPISix() {
		long count = employeeList.stream().filter(employee -> Status.VOCATION.equals(employee.getStatus())).count();
		System.out.println(count);
	}

	//找出工资最高的员工

	@Test
	public void testStreamAPISeven() {
		Optional<Employee> max = employeeList.stream().max(Comparator.comparingDouble(Employee::getSalary));
		System.out.println(max.get());
	}

	//找出员工中工资最低的员工的工资是多少
	@Test
	public void testStreamAPIEight() {
		Optional<Double> min = employeeList.stream().map(Employee::getSalary).min(Double::compare);
		System.out.println(min.get());
	}

}
