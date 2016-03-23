package com.demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo2 {

	final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static void main(String[] args) {
		
		final CountDownLatch begin=new CountDownLatch(2);
		Worker worker1=new Worker("zhangsan",5000,begin);
		Worker worker2=new Worker("lisi",8000,begin);
		worker1.start();
		worker2.start();
		try {
			begin.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("all work done at "+sdf.format(new Date()));
	}
	static class Worker extends Thread{
		
		private String workerName;//工人名字
		private int workTime;// 工作时间
		private CountDownLatch latch;
		public Worker(String workerName,int workTime,CountDownLatch latch){
			this.workerName=workerName;
			this.workTime=workTime;
			this.latch=latch;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("Worker "+workerName+" do work begin at "+sdf.format(new Date()));
			doWork();
			System.out.println("Worker "+workerName+" do work complete at "+sdf.format(new Date()));
			latch.countDown();
		}

		private void doWork(){
			try {
				Thread.sleep(workTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
