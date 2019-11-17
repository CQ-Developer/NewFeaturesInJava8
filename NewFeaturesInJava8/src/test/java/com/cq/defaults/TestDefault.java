package com.cq.defaults;

import org.junit.Test;

public class TestDefault {

	@Test
	public void testDefaultOne() {
		SubClass sub = new SubClass();
		System.out.println(sub.getName());
	}

}
