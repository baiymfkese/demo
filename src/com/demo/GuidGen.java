package com.demo;

import java.util.UUID;

/**
 * 用于生成唯一不重复的id
 *
 * @class GuidGen
 * @author alan
 * @date 2013-5-6 下午8:12:49
 * @since 2.6.5
 */
public class GuidGen {

	public static String getGUID() {
		String retString = UUID.randomUUID().toString();
		System.out.println("original str:"+retString);
		retString = retString.substring(0, 8) + retString.substring(9, 13)
				+ retString.substring(14, 18) + retString.substring(19, 23)
				+ retString.substring(24);
		return retString;
	}

	public static void main(String[] args) {
		GuidGen gg = new GuidGen();
		System.out.println(gg.getGUID());
		String retString = UUID.randomUUID().toString();
		System.out.println(retString);
	}
}
