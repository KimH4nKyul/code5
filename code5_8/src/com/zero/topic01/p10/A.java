package com.zero.topic01.p10;

class A {

	void method() {

		// �ı�ȿ���� �߻������� �����ϴ� ���

		// 1. ���� : ���� ����, ��� ����
		// 2. �߰� : ���ο� ����� �߰�, �������̵�, ���ο� �޼ҵ�
		// 3. ��ü : ���� ��ɰ� ���ο� ����� ���ÿ� ���

		B b = B.createB();

		b.method();

		b.method2();
		b.method("");

		b.method3();

	}

}

// 1. ���� Ŭ������ �߻�ȭ Ŭ������ ����
// 2. ��ü�� ����� ���� method3 ����
// 3. method3 �� ������ B_DV �� B_PR ����
// B �� �����丵 �Ǵ��� A �� ������ ����.
abstract class B {

	public static B createB() {

		boolean ����ȯ�� = true;

		if (����ȯ��) {
			return new B_DV();
		}
		return new B_PR();
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
