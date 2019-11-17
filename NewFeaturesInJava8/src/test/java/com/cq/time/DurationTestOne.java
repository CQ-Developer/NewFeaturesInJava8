/*
Duration
计算两个时间之间的间隔
 */

package com.cq.time;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;

public class DurationTestOne {

	@Test
	public void testDurationOne() throws InterruptedException {
		Instant start = Instant.now();
		Thread.sleep(1500);
		Instant end = Instant.now();
		Duration duration = Duration.between(start, end);
		System.out.println(duration.toMillis());
	}

	@Test
	public void testDurationTwo() throws InterruptedException {
		LocalTime start = LocalTime.now();
		Thread.sleep(1000);
		LocalTime end = LocalTime.now();
		System.out.println(Duration.between(start, end).toMillis());
	}

}
