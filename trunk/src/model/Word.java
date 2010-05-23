package model;

import java.util.HashSet;
import java.util.Set;

public class Word {
	private long key;
	private String value;
	private Set<Long> flags;
	
	
	/**
	 * @param key
	 * @param value
	 */
	public Word(long key, String value) {
		super();
		this.key = key;
		this.value = value;
		this.flags = new HashSet<Long>();
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
	
	public Set<Long> getFlags() {
		return flags;
	}
	
	public void setFlags(Set<Long> flags) {
		this.flags = flags;
	}
	
	public void addFlag(Flag flag){
		this.flags.add(flag.getKey());
	}
	
	public void removeFlag(Flag flag){
		this.flags.remove(flag.getKey());
	}
	
	public boolean hasFlag(Flag flag){
		return (this.flags.contains(flag.getKey()));
	}
}
