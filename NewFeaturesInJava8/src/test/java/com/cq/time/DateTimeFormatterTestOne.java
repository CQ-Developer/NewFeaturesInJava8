/*
时间日期格式化
 */

package com.cq.time;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTimeFormatterTestOne {

	//将时间日期格式化为字符串

	@Test
	public void testFormatterOne() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter isoDate = DateTimeFormatter.ISO_DATE;
		String format = now.format(isoDate);
		System.out.println(format);
	}

	//将时间日期格式化为指定的字符串

	@Test
	public void testFormatterTwo() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分ss秒");
		String dateTimeString = formatter.format(LocalDateTime.now());
		System.out.println(dateTimeString);
	}

	//将时间日期字符串解析为时间日期

	@Test
	public void testFormatterThree() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分ss秒");
		LocalDateTime dateTime = LocalDateTime.parse("2019年11月17日 21时17分26秒", formatter);
		System.out.println(dateTime);
	}

}
