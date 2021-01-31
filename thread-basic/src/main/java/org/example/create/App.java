package org.example.create;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author one
 * @date 2021/01/31
 */
public class App {
    public static void main(String[] args) {
        //方式一
        MyThread myThread = new MyThread();
        myThread.start();

        //方式二
        MyRunnableThread myRunnableThread = new MyRunnableThread();
        Thread thread = new Thread(myRunnableThread);
        thread.start();

        //方式三
        MyCallableThread myCallableThread = new MyCallableThread();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> submit = executorService.submit(myCallableThread);
        try {
            String unused = submit.get();
            System.out.println("得到返回值：" + unused);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}
