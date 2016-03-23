package com.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StringBuilder sb=new StringBuilder("select 123");
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
	}
	public enum Color{
		RED,GREEN;
	}
	class MyThread extends Thread{

		@Override
		public void run() {
			
			try {
				System.out.println("进入睡眠状态");
				Thread.currentThread().sleep(10000);
				System.out.println("睡眠完毕");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("得到中断异常");
			}
			System.out.println("run方法执行完毕");
		}
		
		
	}
}
