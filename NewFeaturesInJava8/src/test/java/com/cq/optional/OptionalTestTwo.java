/*
获取一个男人心中女神的名字
 */

package com.cq.optional;

import com.cq.common.Goddess;
import com.cq.common.Man;
import com.cq.common.NewMan;
import org.junit.Test;

import java.util.Optional;

public class OptionalTestTwo {

	//传统做法各种判空

	@Test
	public void testOptionalOne() {
		Man man = new Man();
		String goddessName = getGoddessName(man);
		System.out.println(goddessName);
	}

	private String getGoddessName(Man man) {
		if (null != man) {
			Goddess goddess = man.getGoddess();
			if (null != goddess) return goddess.getName();
		}
		return "苍老师";
	}

	//使用Optional

	@Test
	public void testOptionalTwo() {
		Optional<NewMan> op1 = Optional.empty();
		System.out.println("op1的女神:" + getGoddessNameOptional(op1));

		Optional<NewMan> op2 = Optional.of(new NewMan());
		System.out.println("op2的女神:" + getGoddessNameOptional(op2));

		Optional<NewMan> op3 = Optional.of(new NewMan().setGoddess(Optional.of(new Goddess("迪丽热巴"))));
		System.out.println("op3的女神:" + getGoddessNameOptional(op3));
	}

	private String getGoddessNameOptional(Optional<NewMan> man) {
		return man.orElseGet(NewMan::new).getGoddess().orElse(new Goddess("苍老师")).getName();
	}
}
