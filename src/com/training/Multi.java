package com.training;


	public class  Multi implements Runnable {

		  public void run() {
			   
			   Thread t = Thread.currentThread();
			   System.out.print(t.getName());
			   //checks if this thread is alive
			   System.out.println(", status = " + t.isAlive());
			   }

		   public static void main (String args[]) throws InterruptedException{
		  
		   Thread t = new Thread(new Multi());
		   // this will call run() function
		   t.start();
		   // waits for this thread to die
		   t.join();
		   System.out.print(t.getName()); 
		   //checks if this thread is alive
		   System.out.println(", status = " + t.isAlive());
		}
		
	   
		   }
