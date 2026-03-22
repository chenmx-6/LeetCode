package juc;

import sun.awt.windows.ThemeReader;

/**
 * @author Miles
 * @date 2026/3/18 0:55
 */
public class SaleTicket {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 400; i++) {
                    ticket.saleTicket();
                }
            }
        },"A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 400; i++) {
                    ticket.saleTicket();
                }
            }
        },"B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 400; i++) {
                    ticket.saleTicket();
                }
            }
        },"C").start();
    }
}
class Ticket{
    private int num=300;
    public synchronized void  saleTicket(){
        if(num>0){
            System.out.println(Thread.currentThread().getName()+"卖出了第"+num--+"张票，还剩"+num+"张");
        }
    }
}
