package com.zero.topic01.p06;

class A {

	void method() {

		// �������̽��� ����Ŭ������ 1:1 ����

		// A -> B <- B_Impl

		// �ı�ȿ���� �߻������� �����ϴ� ���

		// 1. ����(�������̽� ����� ����) : ���� ����, ��� ����
		// 2. �߰�(�����) : ���ο� ����� �߰�, �������̵�, ���ο� �޼ҵ�
		// 3. ��ü(����� ��ȸ�� ���� ) : ���� ��ɰ� ���ο� ����� ���ÿ� ���

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
