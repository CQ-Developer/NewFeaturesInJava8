/*
LocalDate
LocalTime
LocalDateTime
三者的实例时不可变对象,分别表示使用ISO-8601日历系统的日期、时间、日期和时间
它们提供了简单的日期或时间,并不包含当前时间信息,也不包含与时区相关的消息
 */

package com.cq.time;

import org.junit.Test;

import java.time.LocalDate;

public class LocalDateTest {

	//获取当前日期

	@Test
	public void testLocalDateOne() {
		LocalDate date = LocalDate.now();
		System.out.println(date);
	}

	//获取指定的日期

	@Test
	public void testLocalDateTwo() {
		LocalDate date = LocalDate.of(2019, 11, 11);
		System.out.println(date);
	}

	//修改日期,加两年

	@Test
	public void testLocalDateThree() {
		LocalDate date = LocalDate.now().plusYears(2);
		System.out.println(date);
	}

	//修改日期,减两个月

	@Test
	public void testLocalDateFour() {
		LocalDate date = LocalDate.now().minusMonths(2);
		System.out.println(date);
	}

	//获取日期分量

	@Test
	public void testLocalDateFive() {
		LocalDate date = LocalDate.now();
		System.out.println(date.getYear());
		System.out.println(date.getMonthValue());
		System.out.println(date.getDayOfMonth());
	}

}
