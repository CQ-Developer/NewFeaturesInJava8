/*
LocalDate
LocalTime
LocalDateTime
三者的实例时不可变对象,分别表示使用ISO-8601日历系统的日期、时间、日期和时间
它们提供了简单的日期或时间,并不包含当前时间信息,也不包含与时区相关的消息
 */

package com.cq.time;

import org.junit.Test;

import java.time.LocalDateTime;

public class LocalDateTimeTest {

	//获取当前日期时间

	@Test
	public void testLocalDateTimeOne() {
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println(dateTime);
	}

	//获取指定的日期时间

	@Test
	public void testLocalDateTimeTwo() {
		LocalDateTime dateTime = LocalDateTime.of(1991, 1, 11, 1, 11, 11);
		System.out.println(dateTime);
	}

	//修改日期时间,增加3年

	@Test
	public void testLocalDateTimeThree() {
		LocalDateTime dateTime = LocalDateTime.now().plusYears(3);
		System.out.println(dateTime);
	}

	//修改日期时间,减少8个月

	@Test
	public void testLocalDateTimeFour() {
		LocalDateTime dateTime = LocalDateTime.now().minusMonths(8);
		System.out.println(dateTime);
	}

	//获取日期时间分量

	@Test
	public void testLocalDateTimeFive() {
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println(dateTime.getYear() + "年");
		System.out.println(dateTime.getMonthValue() + "月");
		System.out.println(dateTime.getDayOfMonth() + "日");
		System.out.println(dateTime.getHour() + "时");
		System.out.println(dateTime.getMinute() + "分");
		System.out.println(dateTime.getSecond() + "秒");
	}

}
