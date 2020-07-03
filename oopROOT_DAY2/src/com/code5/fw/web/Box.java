package com.code5.fw.web;

import java.io.Serializable;

/**
 * @author seuk
 *
 */
public abstract class Box implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param key
	 * @param object
	 */
	abstract void setAttribute(String key, Object object);

	/**
	 * @param key
	 * @return
	 */
	abstract Object getAttribute(String key);

	/**
	 * @param key
	 * @return
	 */
	public String getString(String key) {

		Object s = getAttribute(key);

		if (s == null) {
			return "";
		}

		if (!(s instanceof String)) {
			return "";

		}

		return (String) s;
	}

	/**
	 * @param key
	 * @param obj
	 */
	public void put(String key, Object obj) {
		setAttribute(key, obj);
	}

	/**
	 * @param key
	 * @return
	 */
	public Object get(String key) {
		return getAttribute(key);
	}

	/**
	 * @param key
	 * @return
	 */
	public String s(String key) {
		return getString(key);
	}
}
