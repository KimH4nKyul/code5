package com.zero.topic01.p03;

import java.util.ArrayList;
import java.util.List;

class A {

	void method() {

		// �ı�ȿ�� ����
		// 3. ��ü : ���� ��ɰ� ���ο� ����� ���ÿ� ���

		// ��ü�� �ʿ䰡 ������ A �ڵ� ����
		B b = new B1();
		// B b = new B2();

		b.method();

	}
}

interface B {
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
