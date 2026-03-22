package juc;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Miles
 * @date 2026/3/18 22:39
 */
public class LSaleTicket {
    public static void main(String[] args) {
        LTicket lTicket = new LTicket();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 400; i++) {
                    lTicket.sale();
                }
            }
        },"A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 400; i++) {
                    lTicket.sale();
                }
            }
        },"B").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 400; i++) {
                    lTicket.sale();
                }
            }
        },"C").start();

    }
}
class LTicket{
    private int num=300;
    private ReentrantLock lock = new ReentrantLock();
    public void sale(){
        lock.lock();
        try{
            if(num>0){
                System.out.println(String.format("%s卖出了第%d张票，还剩%d张；",Thread.currentThread().getName(),num--,num));
            }
        }catch (Exception e){
            lock.unlock();
        }

    }
}
