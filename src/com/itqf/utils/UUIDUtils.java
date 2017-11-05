package com.itqf.utils;

import java.util.UUID;
/*
 * 获取UUID 去掉- 转成大写  用于做数据的id
 * 
 * 
 * 
 * */
public class UUIDUtils {
	public static String getUUID(){
		return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
	}
}
