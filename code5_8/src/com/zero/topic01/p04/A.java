package com.zero.topic01.p04;

class A {

	void method() {

		// �ı�ȿ�� ����
		// 3. ��ü : ���� ��ɰ� ���ο� ����� ���ÿ� ���

		B b = B.createB();
		b.method();
	}

}

interface B {

	public static B createB() {

		// ���丮���� ���� ��ü ���� ����� B �� �̵�
		// A �� �ڵ� ������ �ʿ� ����

		// return new B1();
		return new B2();
	}

	public void method();
}

class B1 implements B {

	public void method() {
	}

}

class B2 implements B {

	public void method() {
	}

}