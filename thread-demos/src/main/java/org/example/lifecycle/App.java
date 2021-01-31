package org.example.lifecycle;

import java.util.concurrent.TimeUnit;

/**
 * 线程生命周期
 *
 * @author one
 * @date 2021/01/31
 */
public class App {
    public static void main(String[] args) {
        //计时等待状态
        new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "TIME_WAITING").start();

        // 等待状态
        new Thread(() -> {
            synchronized (App.class) {
                try {
                    App.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "WAITING").start();

        //阻塞状态
        new Thread(new BlockThread(), "BLOCKED").start();
        new Thread(new BlockThread(), "BLOCKED-2").start();
    }

    static class BlockThread implements Runnable {
        @Override
        public void run() {
            synchronized (BlockThread.class) {
                while (true) {
                    try {
                        TimeUnit.SECONDS.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

}
