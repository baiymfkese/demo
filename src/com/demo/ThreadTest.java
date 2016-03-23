package com.demo;

public class ThreadTest implements Runnable{

	public static int a=0;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int k=0;k<10;k++){
			System.out.println(" "+k+"-------"+Thread.currentThread().getName());
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable task=new ThreadTest();
		Thread t=new Thread(task,"t");
		Thread t1=new Thread(task,"t1");
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t1.start();
	}

}
