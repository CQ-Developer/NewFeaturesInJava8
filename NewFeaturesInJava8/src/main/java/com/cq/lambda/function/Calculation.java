package com.cq.lambda.function;

@FunctionalInterface
public interface Calculation<T> {

	  T calculation(T t);

}
