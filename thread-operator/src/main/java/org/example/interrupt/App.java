package org.example.interrupt;

/**
 * @author one
 * @date 2021/01/31
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().isInterrupted()); //false
                Thread.sleep(3_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        Thread.sleep(1_000);
        thread.interrupt();
        System.out.println(thread.isInterrupted()); //true


        Thread thread2 = new Thread(() -> {
            while (true) {
                while (Thread.currentThread().isInterrupted()) {
                    System.out.println("before:" + Thread.currentThread().isInterrupted());
                    boolean interrupted = Thread.interrupted();// 对中断标识复位为false,返回的是当前中断状态true
                    System.out.println("after:" + Thread.currentThread().isInterrupted());
                    return;
                }
                System.out.println("未中断");
            }
        });
        thread2.start();
        Thread.sleep(1_000);
        thread2.interrupt();
    }
}
