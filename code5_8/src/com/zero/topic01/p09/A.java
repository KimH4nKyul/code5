package com.zero.topic01.p09;

class A {

	void method() {

		// �ı�ȿ�� ����
		// 1. ����(O) : ���� ����, ��� ����
		// 2. �߰�(O) : ���ο� ����� �߰�, �������̵�, ���ο� �޼ҵ�
		// 3. ��ü(O) : ���� ��ɰ� ���ο� ����� ���ÿ� ���

		B b = B.createB();

		b.method();

		b.method2();
		b.method("");

		b.method3();

	}

}

interface B {

	public static B createB() {

		// 3. ��ü : ���� ��ɰ� ���ο� ����� ���ÿ� ���
		// return new B_PR();
		return new B_DV();
	}

	public void method();

	public void method(String p);

	public void method2();

	public void method3();
}

class B_DV implements B {

	public void method() {
		// 1. ���� : ���� ����, ��� ����
	}

	public void method(String p) {
		// 2. �߰� : �������̵�
	}

	public void method2() {
		// 2. �߰� : ���ο� �޼ҵ�
	}

	public void method3() {
		// test stub
	}

}

class B_PR implements B {

	public void method() {
		// 1. ���� : ���� ����, ��� ����
	}

	public void method(String p) {
		// 2. �߰� : �������̵�
	}

	public void method2() {
		// 2. �߰� : ���ο� �޼ҵ�
	}

	public void method3() {
		// ������� ����
	}
}
