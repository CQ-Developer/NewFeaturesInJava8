package com.cq.lambda.function;

@FunctionalInterface
public interface MyPredicate<T> {

	  boolean test(T t);

}
