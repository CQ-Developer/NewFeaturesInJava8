/*
Period
两个日期之间的间隔
 */

package com.cq.time;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Period;

public class PeriodTestOne {

	@Test
	public void testPeriodOne() {
		LocalDate birthday = LocalDate.of(1991, 1, 11);
		LocalDate now = LocalDate.now();
		Period period = Period.between(birthday, now);
		System.out.println("你已经活了:" + period.getYears() + "年," + period.getMonths() + "个月," + period.getDays() + "天");
	}

}
