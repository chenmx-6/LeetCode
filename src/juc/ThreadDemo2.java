package juc;

import sun.util.resources.cldr.ka.LocaleNames_ka;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Miles
 * @date 2026/3/22 16:07
 */
public class ThreadDemo2 {
    public static void main(String[] args) {
        Ticket2 ticket2 = new Ticket2();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    ticket2.increase();
                }
            }
        },"A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    ticket2.decrease();
                }
            }
        },"B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    ticket2.increase();
                }
            }
        },"C").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    ticket2.decrease();
                }
            }
        },"D").start();
    }
}

class Ticket2 {
    private Integer num = 0;

    private Lock lock=new ReentrantLock();

    private Condition condition=lock.newCondition();


    public void increase() {

        try {
            lock.lock();
            while (num != 0) {
                condition.await();
            }
            num++;
            System.out.println(Thread.currentThread().getName()+"加1成功，当前值为："+num);
            condition.signalAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            lock.unlock();
        }

    }

    public void decrease() {
        try {
            lock.lock();
            while (num != 1) {
                condition.await();
            }
            num--;
            System.out.println(Thread.currentThread().getName()+"加1成功，当前值为："+num);
            condition.signalAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            lock.unlock();
        }
    }
}
