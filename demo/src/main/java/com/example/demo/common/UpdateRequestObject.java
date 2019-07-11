package com.example.demo.common;

import java.io.Serializable;

public class UpdateRequestObject implements Serializable {

	private static final long serialVersionUID = -4673700372344642452L;

	private String key;
	private String value;

	public UpdateRequestObject() {
		super();
	}

	public UpdateRequestObject(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "UpdateRequestObject [key=" + key + ", value=" + value + "]";
	}

}
