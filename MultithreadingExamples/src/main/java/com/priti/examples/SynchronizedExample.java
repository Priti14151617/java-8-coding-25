package com.priti.examples;

public class SynchronizedExample {
    private int count = 0;

    public synchronized void increment(){
        count++;
    }

    public synchronized int getCount(){
        return count;
    }

    public static void main(String[] args) throws InterruptedException {

        SynchronizedExample example = new SynchronizedExample();
        Thread t1 = new Thread(()->
        {
            for(int i=0; i<1000;  i++){
                example.increment(); // count = 1000
            }
        });
        Thread t2 = new Thread(()->
        {
            for(int i=0; i<1000;  i++){
                example.increment(); // count = 1000
            }
        });
        Thread t3 = new Thread(()->
        {
            for(int i=0; i<1000;  i++){
                example.increment(); // count = 1000
            }
        });

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("Final count (synchronized): " + example.getCount());
    }
}
