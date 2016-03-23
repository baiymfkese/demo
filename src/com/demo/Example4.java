package com.demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class Example4 implements Runnable{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		BlockingQueue<Runnable> queue=new ArrayBlockingQueue<Runnable>(4);
		ThreadPoolExecutor executor=new ThreadPoolExecutor(2,6,1,TimeUnit.DAYS,queue);
		for(int i=0;i<11;i++){
			executor.execute(new Thread(new Example4(),"name"+i));
			int threadSize=queue.size();
			if(threadSize==4){
				try {
					queue.put(new Runnable(){

						@Override
						public void run() {
							// TODO Auto-generated method stub
							System.out.println("我是新线程");
						}
						
					});
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("线程队列大小为--->"+threadSize);
		}
		executor.shutdown();
		
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized (this) {
			System.out.println("线程名字: "+Thread.currentThread().getName());
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
