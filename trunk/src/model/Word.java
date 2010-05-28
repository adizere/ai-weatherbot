package model;

import java.util.HashSet;
import java.util.Set;

public class Word {
	private long key;
	private String value;
	private Flag flag;
	
	
	/**
	 * @param key
	 * @param value
	 */
	public Word(long key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	public long getKey() {
		return key;
	}
	
	public void setKey(long key) {
		this.key = key;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}

	public Flag getFlag() {
		return flag;
	}

	public void setFlag(Flag flag) {
		this.flag = flag;
	}
	
}
