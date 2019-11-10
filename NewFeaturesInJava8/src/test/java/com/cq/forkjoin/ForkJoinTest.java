/*
ForkJoin框架：
就是在必要的情况下，将一个大任务，拆分(fork)成若干个小任务，
再将一个个小任务运算的结果进行(join)汇总

采用“工作窃取模式”
当执行新的任务时它可以将其拆分分成更小的任务执行，并将小任务加到线程队列中，
然后再从一个随机线程的队列中，偷一个并把它放到自己的队列中。

相对于一般的线程池实现，ForkJoin框架的优势体现在对其中包含的任务的处理方式上，
在一般线程池中，如果一个线程正在执行任务由于某些原因无法继续运行，那么该线程会处于等待状态，
而在ForkJoin框架实现中，如果某个子问题由于等待另外一个子问题的完成而无法继续运行，
那么处理该子问题的线程会主动寻找其他尚未运行的子问题来执行，
这种方式减少了线程的等待时间，提高了性能。
 */

package com.cq.forkjoin;

import com.cq.common.forkjoin.Calculate;
import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class ForkJoinTest {

    //使用传统的for循环

    @Test
    public void testOldOne() {
        long sum = 0L;

        Instant start = Instant.now();
        for (long i = 0L; i < 10000000000L; i++) {
            sum += i;
        }
        Instant end = Instant.now();

        System.out.println("耗费时间" + Duration.between(start, end).toMillis());
    }

    //使用ForkJoin框架

    @Test
    public void testForkJoinOne() {
        Instant start = Instant.now();

        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new Calculate(0L, 10000000000L);
        Long sum = pool.invoke(task);
        System.out.println(sum);

        Instant end = Instant.now();

        System.out.println("耗费时间" + Duration.between(start, end).toMillis());
    }

    //使用Java8新特性：并行流

    @Test
    public void testParallelOne() {
        Instant start = Instant.now();
        long sum = LongStream.rangeClosed(0L, 10000000000L).parallel().sum();
        Instant end = Instant.now();
        System.out.println(sum);
        System.out.println("耗费时间：" + Duration.between(start, end).toMillis());
    }

    @Test
    public void testParalleTwo() {
        Instant start = Instant.now();
        long sum = LongStream.rangeClosed(0L, 10000000000L).parallel().sum();
        Instant end = Instant.now();
        System.out.println(sum);
        System.out.println("耗费时间" + Duration.between(start, end).toMillis());
    }

}
