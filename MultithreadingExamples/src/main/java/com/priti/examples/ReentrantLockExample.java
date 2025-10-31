package com.priti.examples;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

    private int count = 0;
    Lock lock = new ReentrantLock();

    public void increment(){
        lock.lock();
        try{
            count++;
        }
       finally {
            lock.unlock();
        }
    }

    public int getCount(){
        lock.lock();
       try{
          return count;
       }
       finally {
           lock.unlock();
       }

    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockExample rentExample = new ReentrantLockExample();

         Thread t1 = new Thread(()->
         {
             for(int i=0;i<1000;i++)
             {
                 rentExample.increment();
             }
         }
         );


        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                rentExample.increment();
                // Simulate some work
                try { Thread.sleep(1); } catch (InterruptedException e) {}
            }
        });

        Thread t3 = new Thread(() -> {
            // This thread will try to get the count periodically
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread 3 sees count: " + rentExample.getCount());
                try { Thread.sleep(100); } catch (InterruptedException e) {}
            }
        });


       /* Thread t2 = new Thread(()->
        {
            for(int i=0;i<1000;i++)
            {
                rentExample.increment();
                // Simulate some work
                try { Thread.sleep(1); } catch (InterruptedException e) {}
            }
        });*/


       /* Thread t3 = new Thread(()->
        {
            for(int i=0;i<1000;i++)
            {
                System.out.println("Thread 3 sees count: " + rentExample.getCount());
                try { Thread.sleep(100); } catch (InterruptedException e) {}
            }
        });*/


        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("Final count (ReentrantLock): " + rentExample.getCount());

    }
}
