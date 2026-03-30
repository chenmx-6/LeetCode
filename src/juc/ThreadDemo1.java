package juc;

/**
 * @author Miles
 * @date 2026/3/22 16:07
 */
public class ThreadDemo1 {
    public static void main(String[] args) {
        Ticket1 ticket1 = new Ticket1();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    ticket1.increase();
                }
            }
        },"A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    ticket1.decrease();
                }
            }
        },"B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    ticket1.increase();
                }
            }
        },"C").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    ticket1.decrease();
                }
            }
        },"D").start();
    }
}

class Ticket1 {
    private Integer num = 0;

    public synchronized void increase() {

        try {
            while (num != 0) {
                this.wait();
            }
            num++;
            System.out.println(Thread.currentThread().getName()+"加1成功，当前值为："+num);
            notifyAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public synchronized void decrease() {
        try {
            while (num != 1) {
                this.wait();
            }
            num--;
            System.out.println(Thread.currentThread().getName()+"加1成功，当前值为："+num);
            notifyAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
