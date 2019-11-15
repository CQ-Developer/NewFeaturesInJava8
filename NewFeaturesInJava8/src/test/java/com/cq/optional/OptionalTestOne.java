/*
Optional<T>类是一个容器类，代表一个值存在或不存在。
原来用null表示一个值不存在，现在Optional可以更好的表达这个概念，
并且可以避免空指针异常。
 */

package com.cq.optional;

import com.cq.common.Employee;
import com.cq.common.Status;
import org.junit.Test;

import java.util.Optional;

public class OptionalTestOne {

	//Optional.of(T t):创建一个Optional实例

	@Test
	public void testOptionalOne() {
		Optional<Employee> optional = Optional.of(new Employee());
		Employee employee = optional.get();
		System.out.println(employee);
	}

	//Optional.empty():创建一个空的Optional实例

	@Test
	public void testOptionalTwo() {
		Optional<Employee> optional = Optional.empty();
		Employee employee = optional.get();//java.util.NoSuchElementException: No value present
		System.out.println(employee);
	}

	//Optional.ofNullable(T t):若t不为null，创建Optional实例，否则创建空实例

	@Test
	public void testOptionalThree() {
		Optional<Employee> optional = Optional.ofNullable(null);
		Employee employee = optional.get();//java.util.NoSuchElementException: No value present
		System.out.println(employee);
	}

	//isPresent():判断是否有值

	@Test
	public void testOptionalFour() {
		Optional<Employee> optional = Optional.ofNullable(null);
		if (optional.isPresent()) System.out.println(optional.get());
		System.out.println("程序正常结束");
	}

	@Test
	public void testOptionalFive() {
		Optional<Employee> optional = Optional.ofNullable(new Employee());
		if (optional.isPresent()) System.out.println(optional.get());
		System.out.println("程序正常结束");
	}

	//orElse(T t):如果调用对象包含值，返回该值，否则返回t

	@Test
	public void testOptionalSix() {
		Optional<Employee> optional = Optional.empty();
		Employee employee = optional.orElse(new Employee(1, "Tom", 18, 5000.00, Status.FREE));
		System.out.println(employee);
	}

	//orElseGet(Supplier<? extends T> supplier):如果调用对象包含值，返回该值，否则返回supplier获取值

	@Test
	public void testOptionalSeven() {
		Optional<Employee> optional = Optional.empty();
		Employee employee = optional.orElseGet(Employee::new);
		System.out.println(employee);
	}

	//map(Function<? super T, ? extends U> mapper):如果有值对其处理，并返回处理后的Optional，否则返回Optional.empty()

	@Test
	public void testOptionalEight() {
		Optional<Employee> optional = Optional.ofNullable(new Employee(1, "Tom", 18, 5000.00, Status.FREE));
		Optional<String> str = optional.map(Employee::getName);
		System.out.println(str.get());
	}

	//flatMap(Function<? super T, ? extends Optional<? extends U>> mapper):与map类似，要求返回值必须是Optional

	@Test
	public void testOptionalNine() {
		Optional<Employee> optional = Optional.ofNullable(new Employee(1, "Tom", 18, 5000.00, Status.FREE));
		Optional<String> str = optional.flatMap(e -> Optional.ofNullable(e.getName()));
		System.out.println(str.get());
	}

}
