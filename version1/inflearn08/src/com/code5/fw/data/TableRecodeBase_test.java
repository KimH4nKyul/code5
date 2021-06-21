package com.code5.fw.data;

import junit.framework.TestCase;

/**
 * @author zero
 *
 */
public class TableRecodeBase_test extends TestCase {

	/**
	 * 
	 */
	public void test_Table_�⺻���() {

		String[] cols = { "��ȣ", "�̸�" };

		Table table = new TableRecodeBase(cols);

		table.addRecode(new String[] { "1", "ȫ�浿" });
		table.addRecode(new String[] { "2", "ȫ���" });
		table.addRecode(new String[] { "3", "�ι�Ʈ" });

		assertEquals(3, table.size());

		assertEquals("ȫ���", table.s("�̸�", 1));
		assertEquals("ȫ���", table.getBox(1).s("�̸�"));
	}

	/**
	 * 
	 */
	public void test_Table_�����ͼ���() {

		String[] cols = { "��ȣ", "�̸�" };

		Table table = new TableRecodeBase(cols);

		table.addRecode(new String[] { "1", "ȫ�浿" });
		table.addRecode(new String[] { "2", "ȫ���" });
		table.addRecode(new String[] { "3", "�ι�Ʈ" });

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

		String[] cols = { "��ȣ", "�̸�" };

		Table table = new TableRecodeBase(cols);

		table.addRecode(new String[] { "1", "ȫ�浿" });
		table.addRecode(new String[] { "2", "ȫ���" });
		table.addRecode(new String[] { "3", "�ι�Ʈ" });

		table.addCol("����");

		RuntimeException exx = null;
		try {
			table.setData("����", 5, "ȫ�浿ģ��");
		} catch (RuntimeException ex) {
			exx = ex;
		}

		assertNotNull(exx);

	}

	/**
	 * 
	 */
	public void test_Table_�ִ��߰��Ҽ��ִ�ũ��Ȯ��() {

		String[] cols = { "��ȣ", "�̸�" };

		Table table = new TableRecodeBase(cols);

		for (int i = 0; i < 10000; i++) {
			table.addRecode(new String[] { "1", "ȫ�浿" });
			assertEquals(table.isNextRecode(), false);
		}

		assertEquals(table.size(), table.maxRecodeCount());

		assertEquals(table.addRecode(new String[] { "1", "ȫ�浿" }), false);

		assertEquals(table.isNextRecode(), true);

	}
}
