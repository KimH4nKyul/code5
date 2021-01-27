package com.zero.topic01.p09;

class A {

	void method() {

		// �ı�ȿ�� ����
		// 1. ����(O) : ���� ����, ��� ����
		// 2. �߰�(O) : ���ο� ����� �߰�, �������̵�, ���ο� �޼ҵ�
		// 3. ��ü(O) : ���� ��ɰ� ���ο� ����� ���ÿ� ���

		B b = B.createB();
		b.method();
	}

}

interface B {

	public static B createB() {

		// 3. ��ü : ���� ��ɰ� ���ο� ����� ���ÿ� ���
		return new B2();
	}

	public void method();

	public void method(String p);

	public void method2();
}

class B1 implements B {

	public void method() {
		// 1. ���� : ���� ����, ��� ����
	}

	public void method(String p) {
		// 2. �߰� : �������̵�
	}

	public void method2() {
		// 2. �߰� : ���ο� �޼ҵ�
	}

}

class B2 implements B {

	public void method() {
		// 1. ���� : ���� ����, ��� ����
	}

	public void method(String p) {
		// 2. �߰� : �������̵�
	}

	public void method2() {
		// 2. �߰� : ���ο� �޼ҵ�
	}

}
