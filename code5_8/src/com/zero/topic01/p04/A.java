package com.zero.topic01.p04;

class A {

	void method() {

		// �ı�ȿ�� ����
		// 3. ��ü : ���� ��ɰ� ���ο� ����� ���ÿ� ���

		B b = B.createB();
		b.method3();
	}

}

interface B {

	public static B createB() {

		// ���丮���� ���� ��ü ���� ����� B �� �̵�
		// A �� �ڵ� ������ �ʿ� ����

		// return new B_PR();
		return new B_DV();
	}

	public void method3();
}

class B_DV implements B {

	public void method3() {
		// test stub
	}

}

class B_PR implements B {

	public void method3() {
		// ������� ����
	}

}
