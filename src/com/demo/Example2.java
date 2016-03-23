package com.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Example2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Example2 example=new Example2();
		ExecutorService executorService=Executors.newFixedThreadPool(2);
		Thread t1=example.new MyThread("1");
		Thread t2=example.new MyThread("2");
		Thread t3=example.new MyThread("3");
		Thread t4=example.new MyThread("4");
		Thread t5=example.new MyThread("5");
		executorService.execute(t1);
		executorService.execute(t2);
		executorService.execute(t3);
		executorService.execute(t4);
		executorService.execute(t5);
		System.out.println("1111111111111111111111");
		executorService.shutdown();
	}
	class MyThread extends Thread{

		public MyThread(String name){
			super(name);
		}
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName()+" 正在运行......");
		}
		
	}
}
