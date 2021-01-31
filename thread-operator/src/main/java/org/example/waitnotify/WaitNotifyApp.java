package org.example.waitnotify;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author one
 * @date 2021/01/31
 */
public class WaitNotifyApp {
    public static void main(String[] args) {
        Queue<String> bags = new LinkedList<>();
        Producer producer = new Producer(bags, 5);
        Consumer consumer = new Consumer(bags, 3);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
