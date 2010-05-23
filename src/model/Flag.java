package model;

import java.util.HashSet;
import java.util.Set;

public class Flag {
	private long key;
	private String value;
	private Set<Long> associatedWords;	
	/**
	 * @param key
	 * @param value
	 */
	public Flag(long key, String value) {
		super();
		this.key = key;
		this.value = value;
		this.associatedWords = new HashSet<Long>();
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
	
	public void addAssociatedWord(Word word)
	{
		associatedWords.add(word.getKey());
	}
	
	public void removeAssociatedWord(Word word){
		associatedWords.remove(word.getKey());
	}
	
	public boolean hasAssociatedWord(Word word){
		return associatedWords.contains(word.getKey());
	}
}
