/*
时间矫正器
有时我们可能需要获取例如:
将日期调整到"下个周日"等操作
该类通过静态方法提供了大量的常用的实现
 */

package com.cq.time;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

public class TemporalAdjusterTestOne {

	//获取下一个周日

	@Test
	public void testTAOne() {
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime nextSunday = now.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
		System.out.println(nextSunday);
	}

	//下一个工作日

	@Test
	public void testTATwo() {
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime work = now.with(workDay -> {
			LocalDateTime nextWorkDay = (LocalDateTime) workDay;
			DayOfWeek dayOfWeek = nextWorkDay.getDayOfWeek();
			if (dayOfWeek.equals(DayOfWeek.FRIDAY)) {
				return nextWorkDay.plusDays(3);
			} else if (dayOfWeek.equals(DayOfWeek.SATURDAY)) {
				return nextWorkDay.plusDays(2);
			} else {
				return nextWorkDay.plusDays(1);
			}
		});
		System.out.println(work);
	}

}
