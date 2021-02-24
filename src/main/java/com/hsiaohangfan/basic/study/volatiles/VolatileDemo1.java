package com.hsiaohangfan.basic.study.volatiles;

/**
 * JAVA并发之volatile关键字
 * 并发分析的切入点分为两个核心，三大性质。
 * <p>两大核心：JMM内存模型（主内存和工作内存）以及happens-before；三条性质：原子性，可见性，有序性</p>
 * https://www.cnblogs.com/wangwudi/p/12302668.html
 * 被volatile修饰的变量能够保证每个线程能够获取该变量的最新值，从而避免出现数据脏读的现象。
 * volatile主要作用是保证可见性以及有序性。但是volatile是不能保证原子性的！
 * volatile主要解决的是一个线程修改变量值之后，其他线程立马可以读到最新的值，是解决这个问题的，也就是可见性！
 *
 * @author fanxiaohang
 * @date 2021/2/23
 */
public class VolatileDemo1 implements Runnable {
    // 使用volatile关键字定义对象
    private static volatile int a = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new VolatileDemo1());
            thread.start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主内存2================" + a);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            a++;
        }
    }
}
