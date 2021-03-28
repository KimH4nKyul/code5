package com.zero.topic01.p11;

import com.code5.fw.data.InitProperty;

class A {

	void method() {

		B b = B.createB();

		b.method();

		b.method2();
		b.method("");

		b.method3();

	}

}

abstract class B {

	public static B createB() {

		// �ڵ�ȭ�� ������ ����
		if (InitProperty.IS_PRODUCT()) {
			return new B_PR();
		}

		return new B_DV();
	}

	public void method() {
		// 1. ���� : ���� ����, ��� ����
	}

	public void method(String p) {
		// 2. �߰� : �������̵�
	}

	public void method2() {
		// 2. �߰� : ���ο� �޼ҵ�
	}

	abstract public void method3();
}

class B_DV extends B {

	public void method3() {
		// test stub
	}

}

class B_PR extends B {

	public void method3() {
		// ������� ����
	}
}
