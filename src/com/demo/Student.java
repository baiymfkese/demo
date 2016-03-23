package com.demo;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.UUID;

public class Student extends Parent<String,Student> {

	public static void main(String[] args) {
		
		System.out.println(UUID.randomUUID().toString().replaceAll("-","").length());
		
	}
}
