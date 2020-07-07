package com.code5.fw.data;

import junit.framework.TestCase;

/**
 * @author seuk
 *
 */
public class Table_test extends TestCase {

	public void test_Table_����() {
		
		String s1 = "abcd";
		String s2 = "abcd";
		
		System.out.println(s1.hashCode()==s2.hashCode());

		String[][] data = { { "1", "ȫ�浿" }, { "2", "ȫ���" } };
		String[] cols = { "��ȣ", "�̸�" };

		Table table = new Table(cols, data);

		assertEquals(2, table.length());
		assertEquals("ȫ���", table.s("�̸�", 1));
		assertEquals("ȫ���", table.getBox(1).s("�̸�"));
	}

	public void test_Table_�������߰�() {

		String[][] data = { { "1", "ȫ�浿" }, { "2", "ȫ���" } };
		String[] cols = { "��ȣ", "�̸�" };

		Table table = new Table(cols, data);
		table.addData("����", 1, "ȫ�浿ģ��");

		assertEquals(2, table.length());
		assertEquals("ȫ�浿ģ��", table.s("����", 1));
		assertEquals("ȫ�浿ģ��", table.getBox(1).s("����"));
	}

	public void test_Table_�������߰�_2() {

		String[][] data = { { "1", "ȫ�浿" }, { "2", "ȫ���" } };
		String[] cols = { "��ȣ", "�̸�" };

		Table table = new Table(cols, data);
		table.addData("����", 5, "ȫ�浿ģ��");

		assertEquals(5, table.length());

		assertEquals("ȫ�浿ģ��", table.s("����", 5));
		assertEquals("", table.s("����", 4));

	}
}
