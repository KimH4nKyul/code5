package com.zero.topic01.p02;

class A {

	void method() {

		B b = new B();

		// �ı�ȿ�� ����

		// 1. ���� : ���� ����, ��� ����
		b.method();

		// 2. �߰� : ���ο� ����� �߰�, �������̵�, ���ο� �޼ҵ�
		b.method();
		b.method();

		// 3. ��ü : ���� ��ɰ� ���ο� ����� ���ÿ� ���
		b.method3();

	}

}

class B {

	void method() {
		// 1. ���� : ���� ����, ��� ����
	}

	void method(String p) {
		// 2. �߰� : �������̵�
	}

	void method2() {
		// 2. �߰� : ���ο� �޼ҵ�
	}

	// 3. ��ü : ���� ��ɵ� ����ϰ� ���ο� ��ɵ� ���� ���
	void method3() {
		// �����Ҷ��� stub
	}

	void method3() {
		// �ȯ�濡�� ���� ��� ����
	}

}