package org.example.waitnotify;

import java.util.Queue;

/**
 * 消费者
 *
 * @author one
 * @date 2021/01/31
 */
public class Consumer implements Runnable {

    private Queue<String> bags;
    private int size;

    public Consumer(Queue<String> bags, int size) {
        this.bags = bags;
        this.size = size;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        while (true) {
            synchronized (bags) {
                while (bags.isEmpty()) {
                    try {
                        System.out.println("bags 为空");
                        bags.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String remove = bags.remove();
                System.out.println("消费了 " + remove);
                bags.notifyAll();
            }
        }
    }
}
