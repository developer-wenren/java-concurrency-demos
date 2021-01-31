package org.example.sleep;

/**
 * @author one
 * @date 2021/01/31
 */
public class App {
    public static void main(String[] args) {
        SleepThread sleepThread = new SleepThread();
        sleepThread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //中断睡眠
        sleepThread.interrupt();
    }
}
