package com.code5.fw.data;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;

import com.code5.fw.web.Box;
import com.code5.fw.web.BoxLocal;

/**
 * @author seuk
 *
 */
public class Table {

	/**
	 * 
	 */
	private String[][] data = null;

	/**
	 * 
	 */
	private HashMap<String, BigDecimal> colsNameMap = null;

	/**
	 * [1] �߰������͸� �����ϴ� �÷��� ��ü
	 */
	private HashMap<String, String> addData = null;

	/**
	 * [2] �߰������Ͱ� ������ �ִ� row ���� maxLength
	 */
	private int maxLength = -1;

	/**
	 * @param cols
	 * @param data
	 */
	public Table(String[] cols, String[][] data) {

		if (cols == null) {
			throw new RuntimeException();
		}

		if (data == null) {
			throw new RuntimeException();
		}

		if (data.length != cols.length) {
			throw new RuntimeException();
		}

		this.data = data;
		this.colsNameMap = new HashMap<String, BigDecimal>();
		this.maxLength = data.length;

		for (int i = 0; i < cols.length; i++) {
			this.colsNameMap.put(cols[i], new BigDecimal(i));
		}
	}

	/**
	 * 
	 */
	public Table() {
		this.data = new String[][] { {} };
		this.maxLength = 0;
		colsNameMap = new HashMap<String, BigDecimal>();
	}

	/**
	 * @return
	 */
	public int length() {
		if (maxLength == -1) {
			throw new RuntimeException();
		}
		return maxLength;
	}

	/**
	 * @param colName
	 * @param row
	 * @return
	 */
	public String getRowData(String colName, int row) {

		BigDecimal colB = colsNameMap.get(colName);
		if (colB == null) {
			throw new RuntimeException();
		}

		int col = colB.intValue();

		if (data.length < col) {
			return "";
		}

		if (data[col].length < row) {
			return "";
		}

		String thisData = data[col][row];
		if (thisData == null) {
			return "";
		}
		return thisData;

	}

	/**
	 * @param colName
	 * @param row
	 * @return
	 */
	public String getData(String colName, int row) {
		return s(colName, row);
	}

	/**
	 * @param col
	 * @param row
	 * @return
	 * 
	 *         [3] �����ڰ� ������ �����͸� �켱 �����ϰ� ������ �������� �����͸� �����Ѵ�.
	 */
	public String s(String colName, int row) {

		BigDecimal colB = colsNameMap.get(colName);
		if (colB == null) {
			throw new RuntimeException();
		}

		if (addData == null) {
			return getRowData(colName, row);
		}

		String key = colName + "_" + row;
		String data = addData.get(key);
		if (data != null) {
			return data;
		}

		return getRowData(colName, row);

	}

	/**
	 * @param colName
	 * @param row
	 * @param data
	 * 
	 *                [4] �÷��� ��ü�� ������ ��� �߰������ʹ� Map ���·� �����Ѵ�.
	 */
	public void addData(String colName, int row, String data) {

		BigDecimal colB = colsNameMap.get(colName);
		if (colB == null) {
			colsNameMap.put(colName, new BigDecimal(colsNameMap.size() + 1));
		}

		String key = colName + "_" + row;
		

		if (addData == null) {
			addData = new HashMap<String, String>();
		}
		addData.put(key, data);

		if (row > maxLength - 1) {
			maxLength = row;
		}
	}

	/**
	 * @param row
	 * @return
	 */
	public Box getBox(int row) {

		Box box = new BoxLocal();
		Iterator<String> iterator = colsNameMap.keySet().iterator();
		while (iterator.hasNext()) {
			String colName = iterator.next();
			String data = s(colName, row);
			box.put(colName, data);
		}

		return box;

	}

}
