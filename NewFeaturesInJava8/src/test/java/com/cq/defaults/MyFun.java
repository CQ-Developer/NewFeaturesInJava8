/*
Java8中允许接口中有实现的方法
称为默认方法,使用default修饰
 */

package com.cq.defaults;

public interface MyFun {

	default String getName() {
		return "周润发";
	}

}
