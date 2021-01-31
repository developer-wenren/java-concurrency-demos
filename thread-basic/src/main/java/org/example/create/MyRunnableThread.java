package org.example.create;

/**
 * @author one
 * @date 2021/01/31
 */
public class MyRunnableThread implements Runnable {
    @Override
    public void run() {
        System.out.println(MyRunnableThread.class.getSimpleName() + " 类 " + Thread.currentThread().getName() + " 线程执行任务");
    }
}
