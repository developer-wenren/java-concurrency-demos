package org.example.create;

import java.util.concurrent.Callable;

/**
 * @author one
 * @date 2021/01/31
 */
public class MyCallableThread implements Callable<String> {

    @Override
    public String call() {
        String result = MyRunnableThread.class.getSimpleName() + " 类 " + Thread.currentThread().getName() + " 线程执行任务";
        System.out.println(result);
        return result;
    }
}
