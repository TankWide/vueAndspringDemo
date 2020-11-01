package com.example.demo.util;

/**
 * @author tangkk
 * 设置登录信息到当前线程
 */
public class UserThreadLocal {

	private UserThreadLocal() {
	}

	private static final ThreadLocal<Integer> LOCAL = new ThreadLocal<>();

	public static void set(Integer userName) {
		LOCAL.set(userName);
	}

	public static Integer get() {
		return LOCAL.get();
	}

	public static void remove() {
		LOCAL.remove();
	}
}
