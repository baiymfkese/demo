package com.demo;

import java.util.concurrent.atomic.AtomicInteger;
/**
 * 
 * @author ming
 *
 */
public class Counter {

	private AtomicInteger count=new AtomicInteger(5);
	
	public void increment(){
		
		count.incrementAndGet();
	}
	public int getCount(){
		
		return count.get();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Counter counter=new Counter();
		counter.increment();
		counter.increment();
		System.out.println("before------"+counter.getCount());
		
		counter.count.set(12);
		counter.increment();
		counter.increment();
		System.out.println(counter.getCount());
	}

}
