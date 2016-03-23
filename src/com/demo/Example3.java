package com.demo;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Example3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ScheduledExecutorService cachedExecutorService=Executors.newSingleThreadScheduledExecutor();
		for(int i=0;i<10;i++){
			final int index=i;
			cachedExecutorService.execute(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
						System.out.println(index);
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
				
			});
		}
//		cachedExecutorService.schedule(new Runnable(){
//
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				System.out.println("delay 3 seconds");
//			}
//			
//		},3,TimeUnit.SECONDS);
//		cachedExecutorService.scheduleAtFixedRate(new Runnable(){
//
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				System.out.println("delay 1 seconds,and execute every 3 seconds");
//			}
//			
//		}, 1, 3, TimeUnit.SECONDS);
		//cachedExecutorService.shutdown();
	}
	class MyThread implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			for(int i=0;i<3;i++){
				System.out.println(Thread.currentThread().getName());
			}
		}

		
		
	}
}
