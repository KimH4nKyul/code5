package com.code5.fw.trace;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.code5.fw.data.InitProperty;

/**
 * @author zero
 *
 */
class Trace_test {

	@BeforeAll
	static void setUp() throws Exception {
		InitProperty.init(Trace_test.class);
	}

	/**
	 * @throws Exception
	 */
	@Test
	void test_01_������ü() throws Exception {

		Trace trace01 = new Trace(this);

		trace01.write("�����ٶ�");
		trace01.write("" + 123);
		trace01.write(trace01.toString());
	}

	Trace trace02 = new Trace(this);

	/**
	 * @throws Exception
	 */
	@Test
	void test_02_�ɹ���ü() throws Exception {

		trace02.write("�����ٶ�");
		trace02.write("" + 123);
		trace02.write(trace02.toString());
	}

	private static Trace TRACE_03 = new Trace(Trace_test.class);

	/**
	 * @throws Exception
	 */
	@Test
	void test_03_������ü() throws Exception {

		TRACE_03.write("�����ٶ�");
		TRACE_03.write("" + 123);
		TRACE_03.write(TRACE_03.toString());
	}

	/**
	 * @throws Exception
	 */
	@Test
	void test_���Ͼ�����_�αױ��() throws Exception {

		Trace trace = new Trace(Trace_test.class);

		trace.write("�����ٶ�");
		trace.write("" + 123);
		trace.write(trace.toString());
	}

	/**
	 * @throws Exception
	 */
	@Test
	void test_��Ƽ������_�αױ��() throws Exception {

		InitProperty.init(Trace_test.class.getName(), true);
		TraceRunner traceRunner = TraceRunner.getTraceRunner();

		Trace_test$[] t = new Trace_test$[10];
		for (int i = 0; i < t.length; i++) {
			t[i] = new Trace_test$(i);
			t[i].start();
		}

		for (int i = 0; i < t.length; i++) {
			t[i].join();
			System.err.println("fin " + i);
		}

		traceRunner.flush();
	}

}

class Trace_test$ extends Thread {

	int thisID = -1;

	public Trace_test$(int i) {
		thisID = i;
	}

	@Override
	public void run() {

		Trace trace = new Trace(this);

		String msg = null;
		for (int i = 0; i < 100000; i++) {
			msg = thisID + " �αױ�� �����ٶ� abcd" + i;
			trace.write(msg);
		}

	}
}