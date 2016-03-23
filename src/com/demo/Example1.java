package com.demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Example1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ScheduledExecutorService ses=Executors.newScheduledThreadPool(2);
		Runnable task=new Runnable(){
			int count=0;
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(sdf.format(new Date())+" "+(++count));
			}
		};
		ScheduledFuture sf=ses.scheduleAtFixedRate(task, 1, 2, TimeUnit.SECONDS);
	}

}
