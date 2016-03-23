package com.demo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo {

	public static void main(String[] args) {
		
		final CountDownLatch begin=new CountDownLatch(1);
		final CountDownLatch end=new CountDownLatch(10);
		final ExecutorService exectors=Executors.newFixedThreadPool(10);
		for(int i=0;i<10;i++){
			final int index=i+1;
			Runnable task=new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						begin.await();
						Thread.sleep((long)(Math.random()*10000));
						System.out.println("No. "+index+" arrived.");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally{
						end.countDown();
					}
				}
				
			};
			exectors.submit(task);
		}
		System.out.println("Game Start.....");
		begin.countDown();
		try {
			end.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Game Over....");
		exectors.shutdown();
		
	}
}
