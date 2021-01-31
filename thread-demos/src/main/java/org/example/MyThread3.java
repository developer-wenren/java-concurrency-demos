package org.example;

import java.util.concurrent.Callable;

/**
 * @author one
 * @date 2021/01/31
 */
public class MyThread3 implements Callable<String> {
    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     */
    @Override
    public String call() {
        String result = MyThread2.class.getSimpleName() + " 类 " + Thread.currentThread().getName() + " 线程执行任务";
        System.out.println(result);
        return result;
    }
}
