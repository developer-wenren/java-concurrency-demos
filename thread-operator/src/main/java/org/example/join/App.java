package org.example.join;

/**
 * @author one
 * @date 2021/01/31
 */
public class App {
    private static int i = 0;
    private static int a = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread aThread = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i = 1;
            a = 2;
        });
        Thread bThread = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i = a + 3;
        });
        aThread.start();
        aThread.join();
        bThread.start();
        Thread.sleep(5000);
        System.out.println(String.format("value i:%s,a:%s", i, a));
        // 有 join 方法，输出：value i:5,a:2；
        // 无 join 方法，输出：value i:1,a:2
    }
}
