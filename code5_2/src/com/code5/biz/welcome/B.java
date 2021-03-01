package com.code5.biz.welcome;

/**
 * @author zero
 *
 */
public class B {

	// 1. �Ķ����

	/**
	 * @param a
	 */
	public void execute_01(A a) {
		a.execute();
	}

	// 2. �ɹ���ü or static

	// private A a = new A();
	private static A A = new A();

	public static void execute_02() {
		A.execute();
	}

	// 3. ThreadLocal

	/**
	 * 
	 */
	public void execute_03() {
		A a = th.get();
		a.execute();
	}

	ThreadLocal<A> th = new ThreadLocal<A>();
}
