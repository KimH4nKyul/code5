package com.zero.topic01.p07;

class A {

	void method() {

		// �������̽��� ����Ŭ������ 1:1 ����

		// A -> B <- B_Impl

		// �ı�ȿ�� ����
		// 1. ����(O) : ���� ����, ��� ����
		// 2. �߰�(X) : ���ο� ����� �߰�, �������̵�, ���ο� �޼ҵ�
		// 3. ��ü(X) : ���� ��ɰ� ���ο� ����� ���ÿ� ���

		// �������̽��� ����Ѵٰ� �ص� �ı�ȿ���� �ذ��� �� �ִ� ����� �پ���� �ʴ´�.
		// ������ �� ����!

		B b = new B_Impl();
		b.method();
	}

}

interface B {
	public void method();
}

class B_Impl implements B {

	public void method() {
		// 1. ���� : ���� ����, ��� ����
	}

	void method(String p) {
		// 2. �߰� : �������̵�
	}

	void method2() {
		// 2. �߰� : ���ο� �޼ҵ�
	}

}
