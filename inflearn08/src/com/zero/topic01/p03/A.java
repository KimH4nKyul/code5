package com.zero.topic01.p03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class A {

	void method() {

		// �ı�ȿ���� �߻������� �����ϴ� ���
		// 3. ��ü : ���� ��ɰ� ���ο� ����� ���ÿ� ���

		// ��ü�� ���� A �ڵ� ����
		boolean ����ȯ�� = true;

		B b = new B_PR();
		if (����ȯ��) {
			b = new B_DV();
		}

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

		// new �� ������ ��ü�� �Ϻη� �߻�ȭ �� ����� �ʿ䰡 ����.

		List<String> list = new ArrayList<String>();
		sort(list);
		((ArrayList<String>) list).addAll(null);

		ArrayList<String> list2 = new ArrayList<String>();
		sort(list2);
		list2.addAll(null);

		LinkedList<String> list3 = new LinkedList<String>();
		sort(list3);
		list3.getFirst();

	}

	void sort(List<String> list) {

		// �������� ġȯ ��Ģ
		// �߻�ȭ ����

	}
}
