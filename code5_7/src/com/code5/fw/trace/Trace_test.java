package com.code5.fw.trace;

import junit.framework.TestCase;

/**
 * @author seuk
 *
 */
public class Trace_test extends TestCase {

	/**
	 * 
	 */
	public void test_���Ͼ�����_�αױ��() {

		TraceRunner.getTraceRunner().init(Trace_test.class.getName());

		Trace trace = new Trace(Trace_test.class);
		trace.write("�����ٶ�");
		trace.write("abcd");
		trace.write("1234");
	}

	public void test_��Ƽ������_�αױ��() {

	}

}

class Trace_test$ extends Thread {

	@Override
	public synchronized void start() {

		Trace trace = new Trace(this);

		int hash = this.hashCode();

		for (int i = 0; i < 10000; i++) {
			trace.write("�αױ�� �����ٶ� " + hash + " " + i);
		}

	}
}