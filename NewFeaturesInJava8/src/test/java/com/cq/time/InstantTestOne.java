/*
时间戳
以Unix元年,1970年1月1日00:00:00到现在的毫秒值
 */

package com.cq.time;

import org.junit.Test;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class InstantTestOne {

	//默认获取UTC时区

	@Test
	public void testInstantOne() {
		Instant instant = Instant.now();
		System.out.println(instant);
	}

	//带偏移量的时区显示

	@Test
	public void testInstantTwo() {
		OffsetDateTime offsetDateTime = Instant.now().atOffset(ZoneOffset.ofHours(8));
		System.out.println(offsetDateTime);
	}

	//获取毫秒数

	@Test
	public void testInstantThree() {
		Instant instant = Instant.now();
		System.out.println(instant.toEpochMilli());
	}

	//从时间原点加60秒

	@Test
	public void testInstantFour() {
		Instant instant = Instant.ofEpochSecond(60);
		System.out.println(instant);
	}

}
