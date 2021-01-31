package org.example;

/**
 * 继承 Thread 方式创建线程
 *
 * @author one
 * @date 2021/01/31
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(MyThread.class.getSimpleName() + " 类 " + Thread.currentThread().getName() + " 线程执行任务");
    }
}
