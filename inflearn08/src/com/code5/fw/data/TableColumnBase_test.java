package com.code5.fw.data;

import junit.framework.TestCase;

/**
 * @author seuk
 *
 */
public class TableColumnBase_test extends TestCase {

	/**
	 * 
	 */
	public void test_Table_�⺻���() {

		Table table = new TableColumnBase();

		table.addCol("��ȣ", new String[] { "1", "2", "3" });
		table.addCol("�̸�", new String[] { "ȫ�浿", "ȫ���", "�ι�Ʈ" });

		assertEquals(3, table.size());

		assertEquals("ȫ���", table.s("�̸�", 1));
		assertEquals("ȫ���", table.getBox(1).s("�̸�"));
	}

	/**
	 * 
	 */
	public void test_Table_�����ͼ���() {

		Table table = new TableColumnBase();

		table.addCol("��ȣ", new String[] { "1", "2", "3" });
		table.addCol("�̸�", new String[] { "ȫ�浿", "ȫ���", "�ι�Ʈ" });

		table.addCol("����");

		table.setData("����", 1, "ȫ�浿ģ��");

		assertEquals(3, table.size());
		assertEquals("ȫ�浿ģ��", table.s("����", 1));
		assertEquals("ȫ�浿ģ��", table.getBox(1).s("����"));
	}

	/**
	 * 	
	 */
	public void test_Table_�����Ҽ����µ�����() {

		Table table = new TableColumnBase();

		table.addCol("��ȣ", new String[] { "1", "2", "3" });
		table.addCol("�̸�", new String[] { "ȫ�浿", "ȫ���", "�ι�Ʈ" });

		table.addCol("����");

		RuntimeException exx = null;
		try {
			table.setData("����", 5, "ȫ�浿ģ��");
		} catch (RuntimeException ex) {
			exx = ex;
		}

		assertNotNull(exx);

	}
}
