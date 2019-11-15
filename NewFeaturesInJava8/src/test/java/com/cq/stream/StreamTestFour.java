/*
终止操作：

规约：reduce
可以将流中元素反复结合起来，得到一个值
 */

package com.cq.stream;

import com.cq.common.Employee;
import com.cq.common.Status;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamTestFour {

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

	//求1到10的和

	@Test
	public void testStreamAPIOne() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		Integer sum = list.stream().reduce(0, Integer::sum);
		System.out.println(sum);
	}

	//计算工资的综合

	@Test
	public void testStreamAPITwo() {
		Optional<Double> sum = employeeList.stream().map(Employee::getSalary).reduce(Double::sum);
		System.out.println(sum.get());
	}

}
