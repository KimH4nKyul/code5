package com.zero.topic01.p03;

import java.util.ArrayList;
import java.util.List;

class A {

	void method() {

		// �ı�ȿ�� ����
		// 3. ��ü : ���� ��ɰ� ���ο� ����� ���ÿ� ���

		// ��ü�� �ʿ䰡 ������ A �ڵ� ����
		B b = new B_DV();
		// B b = new B_PR();

		b.method3();

	}
}

interface B {
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

class C {

	void moethod() {

		// �߸��� ��ü ����, �������� �߻�ȭ ���

		List<String> list = new ArrayList<String>();
		sort(list);

		((ArrayList<String>) list).addAll(null);

		// �Ϻη� �������̽��� �߻�ȭ �� ����� �ʿ�� ����.

		ArrayList<String> list2 = new ArrayList<String>();
		sort(list2);

		list2.addAll(null);

	}

	void sort(List<String> list) {

		// �߻�ȭ�� ����
		// OOP �������� ��Ģ

	}
}
