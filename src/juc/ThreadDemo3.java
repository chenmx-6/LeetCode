package juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Miles
 * @date 2026/3/22 17:42
 */
public class ThreadDemo3 {

    public static void main(String[] args) {
        SharedResource3 sharedResource3 = new SharedResource3();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    sharedResource3.print5(i+1);
                }
            }
        },"A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    sharedResource3.print10(i+1);
                }
            }
        },"B").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    sharedResource3.print15(i+1);
                }
            }
        },"C").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    sharedResource3.print5(i+1);
                }
            }
        },"D").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    sharedResource3.print10(i+1);
                }
            }
        },"E").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    sharedResource3.print15(i+1);
                }
            }
        },"F").start();
    }
}

class SharedResource3{
    private int flag=1;
    private Lock lock=new ReentrantLock();
    private Condition c1=lock.newCondition();
    private Condition c2=lock.newCondition();
    private Condition c3=lock.newCondition();


    public void print5(int turn){
        lock.lock();
        try{
            while(flag!=1){
                c1.await();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println("第"+turn+"轮："+Thread.currentThread().getName()+"打印第"+(i+1)+"次");
            }
            flag=2;
            c2.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            lock.unlock();
        }

    }
    public void print10(int turn){
        lock.lock();
        try{
            while(flag!=2){
                c2.await();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println("第"+turn+"轮："+Thread.currentThread().getName()+"打印第"+(i+1)+"次");
            }
            flag=3;
            c3.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            lock.unlock();
        }

    }

    public void print15(int turn){
        lock.lock();
        try{
            while(flag!=3){
                c3.await();
            }
            for (int i = 0; i < 15; i++) {
                System.out.println("第"+turn+"轮："+Thread.currentThread().getName()+"打印第"+(i+1)+"次");
            }
            flag=1;
            c1.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            lock.unlock();
        }

    }

}
