package com.code5.fw.web;

import com.code5.fw.data.Box;
import com.code5.fw.data.BoxLocal;

/**
 * @author seuk
 *
 */
public class BoxContext_test {

	static Box box = new BoxLocal();

	public static void main(String[] xxx) throws Exception {

		// X = abcd

		// X = �����ٶ�

		Box box = BoxContext_test.box;
		box.put("X", xxx[0]);

		A a = new A();
		a.printlnX();

		// [
		B.printlnX();

		// abcd
		// abcd

		// abcd
		// �⳪�ٶ�

	}

}

class A {

	void printlnX() {
		Box box = BoxContext_test.box;
		System.out.println(box.s("X"));

	}
}

class B {

	static void printlnX() {
		Box box = BoxContext_test.box;
		System.out.println(box.s("X"));
	}

}
