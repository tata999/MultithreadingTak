package com.training;

public class MultiThreading implements Runnable{


 String name; // name of thread
 Thread t;

 MultiThreading(String threadname) {
     name = threadname;
     t = new Thread(this, name);
     System.out.println("New thread: " + t);
     t.start(); // Start the thread
 }
//This is the entry point for thread.

 public void run() {
     try {
         for (int i = 5; i > 0; i--) {
             System.out.println(name + ": " + i);
             Thread.sleep(1000);
         }
     } catch (InterruptedException e) {
         System.out.println(name + " interrupted.");
     }
     System.out.println(name + " exiting.");
 }



 public static void main(String args[]) {
     MultiThreading ob1 = new MultiThreading("One");
     MultiThreading ob2 = new MultiThreading("Two");
     MultiThreading ob3 = new MultiThreading("Three");
     System.out.println("Thread One is alive: "
             + ob1.t.isAlive());
     System.out.println("Thread Two is alive: "
             + ob2.t.isAlive());
     System.out.println("Thread Three is alive: "
             + ob3.t.isAlive());
//wait for threads to finish
     try {
         System.out.println("Waiting for threads to finish.");
         ob1.t.join();
         ob2.t.join();
         ob3.t.join();
     } catch (InterruptedException e) {
         System.out.println("Main thread Interrupted");
     }
     System.out.println("Thread One is alive: "
             + ob1.t.isAlive());
     System.out.println("Thread Two is alive: "
             + ob2.t.isAlive());
     System.out.println("Thread Three is alive: "
             + ob3.t.isAlive());
     System.out.println("Main thread exiting.");
 }
}