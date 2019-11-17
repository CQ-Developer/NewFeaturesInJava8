/*
Java8提供了注解的新机制
重复注解与类型注解
 */

package com.cq.annotation;

import com.cq.common.MyAnnotation;
import org.junit.Test;

import java.lang.reflect.Method;

public class AnnotationTest {

	@MyAnnotation("Hello")
	@MyAnnotation("World")
	public void show() {}

	//可重复注解

	@Test
	public void testAnnotationOne() throws Exception {
		Class<AnnotationTest> cls = AnnotationTest.class;
		Method show = cls.getMethod("show");
		MyAnnotation[] annotations = show.getAnnotationsByType(MyAnnotation.class);
		for (MyAnnotation annotation : annotations) {
			System.out.println(annotation.value());
		}
	}

	//类型注解

	@MyAnnotation("Hello")
	@MyAnnotation("World")
	public void show(@MyAnnotation("abc") String str) {}

}
