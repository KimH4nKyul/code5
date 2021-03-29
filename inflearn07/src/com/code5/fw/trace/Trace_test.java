package com.code5.fw.trace;

import junit.framework.TestCase;

/**
 * @author zero
 *
 */
public class Trace_test extends TestCase {

	@Override
	protected void setUp() throws Exception {
		// TraceRunner traceRunner = TraceRunner.getTraceRunner();
		// traceRunner.init(Trace_test.class.getName());
	}

	public void xtest_01_������ü() throws Exception {

		Trace trace01 = new Trace(this);

		trace01.write("�����ٶ�");
		trace01.write("" + 123);
		trace01.write(trace01.toString());
	}

	Trace trace02 = new Trace(this);

	public void xtest_02_�ɹ���ü() throws Exception {

		trace02.write("�����ٶ�");
		trace02.write("" + 123);
		trace02.write(trace02.toString());
	}

	private static Trace TRACE_03 = new Trace(Trace_test.class);

	public void xtest_03_������ü() throws Exception {

		TRACE_03.write("�����ٶ�");
		TRACE_03.write("" + 123);
		TRACE_03.write(TRACE_03.toString());
	}

	/**
	 * 
	 */
	public void xtest_���Ͼ�����_�αױ��() throws Exception {

		Trace trace = new Trace(Trace_test.class);

		trace.write("�����ٶ�");
		trace.write("" + 123);
		trace.write(trace.toString());
	}

	public void test_��Ƽ������_�αױ��() throws Exception {

		TraceRunner traceRunner = TraceRunner.getTraceRunner();
		traceRunner.init(Trace_test.class.getName(), true);

		Trace_test$[] t = new Trace_test$[10];
		for (int i = 0; i < t.length; i++) {
			t[i] = new Trace_test$();
			t[i].start();
		}

		for (int i = 0; i < t.length; i++) {
			t[i].join();
		}

		traceRunner.flush();

	}

}

class Trace_test$ extends Thread {

	@Override
	public void run() {

		Trace trace = new Trace(this);

		int hash = this.hashCode();

		for (int i = 0; i < 100000; i++) {
			trace.write("�αױ�� �����ٶ� " + hash + " " + i);
			// System.err.println("�αױ�� �����ٶ� " + hash + " " + i);
		}

	}
}