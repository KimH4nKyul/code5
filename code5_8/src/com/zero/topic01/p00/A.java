package com.zero.topic01.p00;

class A {

	void method() {

		// �������̽��� ��ü����� ���̱� ���� ����մϴ�.

		// �������̽��� ����Ŭ������ 1:1 ����

		// A -> B <- B_Impl

		B b = new B_Impl();
		b.method();
	}

}

interface B {
	public void method();
}

class B_Impl implements B {

	public void method() {
	}

}
