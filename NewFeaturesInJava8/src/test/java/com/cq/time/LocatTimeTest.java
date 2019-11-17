/*
LocalDate
LocalTime
LocalDateTime
三者的实例时不可变对象,分别表示使用ISO-8601日历系统的日期、时间、日期和时间
它们提供了简单的日期或时间,并不包含当前时间信息,也不包含与时区相关的消息
 */

package com.cq.time;

import org.junit.Test;

import java.time.LocalTime;

public class LocatTimeTest {

	//获取当前时间

	@Test
	public void testLocalTimeOne() {
		LocalTime time = LocalTime.now();
		System.out.println(time);
	}

	//获取指定时间

	@Test
	public void testLocalTimeTwo() {
		LocalTime time = LocalTime.of(11, 11, 11);
		System.out.println(time);
	}

	//修改时间,增加两小时

	@Test
	public void testLocalTimeThree() {
		LocalTime time = LocalTime.now().plusHours(2);
		System.out.println(time);
	}

	//修改时间,减五分钟

	@Test
	public void testLocalTimeFour() {
		LocalTime time = LocalTime.now().minusMinutes(5);
		System.out.println(time);
	}

	//获取时间分量

	@Test
	public void testLocalTimeFive() {
		LocalTime time = LocalTime.now();
		System.out.println(time.getHour());
		System.out.println(time.getMinute());
		System.out.println(time.getSecond());
	}

}
