package com.zero.topic01.p08;

class A {

	void method() {

		// �������̽��� ����Ŭ������ 1:1 ����

		// A -> B <- B_Impl

		// �������̽��� ����Ѵٰ� �ص� �ı�ȿ�� �����ϴ� ����� ���� �ʴ´�!
		// ������ ����!

		// �ı�ȿ���� �߻������� �����ϴ� ���

		// 1. ����(�������̽� ����� ����) : ���� ����, ��� ����
		// 2. �߰�(�����) : ���ο� ����� �߰�, �������̵�, ���ο� �޼ҵ�
		// 3. ��ü(��ȸ�� ����) : ���� ��ɰ� ���ο� ����� ���ÿ� ���

		B b = B.createB();

		b.method();

		b.method2();
		b.method("");

		b.method3();

	}

}

interface B {

	public static B createB() {

		boolean ����ȯ�� = true;

		if (����ȯ��) {
			return new B_DV();
		}
		return new B_PR();
	}

	public void method();

	public void method(String p);

	public void method2();

	public void method3();
}

class B_DV implements B {

	public void method() {
		// 1. ���� : ���� ����, ��� ����
		// �ߺ��ڵ�
	}

	public void method(String p) {
		// 2. �߰� : �������̵�
		// �ߺ��ڵ�
	}

	public void method2() {
		// 2. �߰� : ���ο� �޼ҵ�
		// �ߺ��ڵ�
	}

	public void method3() {
		// test stub
	}

}

class B_PR implements B {

	public void method() {
		// 1. ���� : ���� ����, ��� ����
		// �ߺ��ڵ�
	}

	public void method(String p) {
		// 2. �߰� : �������̵�
		// �ߺ��ڵ�
	}

	public void method2() {
		// 2. �߰� : ���ο� �޼ҵ�
		// �ߺ��ڵ�
	}

	public void method3() {
		// ������� ����
	}
}
