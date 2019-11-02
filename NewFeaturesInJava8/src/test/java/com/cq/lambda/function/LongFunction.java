package com.cq.lambda.function;

@FunctionalInterface
public interface LongFunction<T, R> {

	  R getValue(T t1, T t2);
}
