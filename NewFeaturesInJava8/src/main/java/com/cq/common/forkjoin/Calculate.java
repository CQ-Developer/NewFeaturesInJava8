/*
计算整数的累加
使用ForkJoin框架和普通for循环进行，
对比使用时间
 */

package com.cq.common.forkjoin;

import java.util.concurrent.RecursiveTask;

public class Calculate extends RecursiveTask<Long> {

    private static final long serialVersionUID = 6774731049872912955L;

    private Long start;
    private Long end;

    private final Long THREHOLD = 10000L;

    public Calculate(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        Long length = end - start;
        if (length <= THREHOLD) {
            Long sum = 0L;
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            Long middle = (start + end) / 2;
            Calculate left = new Calculate(start, middle);
            left.fork();//拆分子任务，同时压入线程队列
            Calculate right = new Calculate(middle + 1, end);
            right.fork();
            return left.join() + right.join();
        }
    }

}
