package org.example.waitnotify;

import java.util.Queue;

/**
 * 生产者
 *
 * @author one
 * @date 2021/01/31
 */
public class Producer implements Runnable {
    private Queue<String> bags;
    private int size;

    public Producer(Queue<String> bags, int size) {
        this.bags = bags;
        this.size = size;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            synchronized (bags) {
                while (bags.size() == size) {
                    try {
                        System.out.println("bags 满了");
                        bags.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("生成了 bog—" + (++i));
                bags.add("bag-" + i);
                bags.notifyAll();
            }
        }

    }
}
