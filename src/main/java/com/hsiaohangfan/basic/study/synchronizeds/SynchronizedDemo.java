package com.hsiaohangfan.basic.study.synchronizeds;

/**
 * Java并发synchronized关键字
 * 并发分析的切入点分为两个核心，三大性质。
 * <p>两大核心：JMM内存模型（主内存和工作内存）以及happens-before；三条性质：原子性，可见性，有序性</p>
 * 由于未加锁，所以每个线程读到的count初始值不同，一次累加结果不一定等于100000
 * Thread和Runnable的实现和多线程的区别
 *
 * @author fanxiaohang
 * @date 21/2/24
 */
public class SynchronizedDemo implements Runnable {
    private static int count = 0;

    public static void main(String[] args) {
        /**
         * 这里开启3个线程进行count++
         */
        for (int i = 0; i < 2; i++) {
            Thread thread = new Thread(new SynchronizedDemo());
            thread.start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }
}
