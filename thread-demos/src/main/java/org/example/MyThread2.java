package org.example;

/**
 * @author one
 * @date 2021/01/31
 */
public class MyThread2 implements Runnable {
    @Override
    public void run() {
        System.out.println(MyThread2.class.getSimpleName() + " 类 " + Thread.currentThread().getName() + " 线程执行任务");
    }
}
