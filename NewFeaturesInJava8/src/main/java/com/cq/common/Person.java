package com.cq.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Person implements Serializable {

	private static final long serialVersionUID = -1628510570243799833L;

	private Integer id;
	private String name;
	private Integer age;
	private Double salary;

	public Person(Integer id) {
		this.id = id;
	}

	public Person(Integer id, Integer age) {
		this.id = id;
		this.age = age;
	}

}
