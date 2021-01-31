package org.example;

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
        MyThread2 myThread2 = new MyThread2();
        Thread thread = new Thread(myThread2);
        thread.start();

        //方式三
        MyThread3 myThread3 = new MyThread3();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> submit = executorService.submit(myThread3);
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
