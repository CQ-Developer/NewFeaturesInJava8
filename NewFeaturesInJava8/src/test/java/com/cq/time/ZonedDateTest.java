/*
对时区的操作
 */

package com.cq.time;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

public class ZonedDateTest {

	//查看所有支持的时区

	@Test
	public void testZonedOne() {
		Set<String> ids = ZoneId.getAvailableZoneIds();
		System.out.println(ids.size());
		ids.forEach(System.out::println);
	}

	//获取指定时区的时间

	@Test
	public void testZonedTwo() {
		LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Qatar"));
		System.out.println(now);
	}

	//获取带时区的时间日期

	@Test
	public void testZoneThree() {
		LocalDateTime dateTime = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
		ZonedDateTime zonedDateTime = dateTime.atZone(ZoneId.of("Asia/Shanghai"));
		System.out.println(zonedDateTime);
	}

}
