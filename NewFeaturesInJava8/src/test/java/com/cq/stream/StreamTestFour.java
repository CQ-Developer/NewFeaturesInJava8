/*
终止操作：

规约：reduce
可以将流中元素反复结合起来，得到一个值
 */

package com.cq.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class StreamTestFour {

	@Test
	public void testStreamAPIOne() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		Integer sum = list.stream().reduce(0, Integer::sum);
		System.out.println(sum);
	}

}
