package org.example.sleep;

/**
 * @author one
 * @date 2021/01/31
 */
public class SleepThread extends Thread {
    @Override
    public void run() {
        System.out.println("begin:" + System.currentTimeMillis());
        try {
            Thread.sleep(3000); //睡眠3秒
            System.out.println("end:" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            System.out.println("睡眠被中断:" + System.currentTimeMillis());
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
