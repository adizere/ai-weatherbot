package model;

public class Word {
	
	private long id;
	
	private String value;
	private Flag flag;	
	
	/**
	 * @param id
	 * @param value
	 * @param flag
	 */
	public Word(long id, String value, Flag flag) {
		super();
		this.id = id;
		this.value = value;
		this.flag = flag;
	}
	
	/**
	 * @param id
	 * @param value
	 */
	public Word(long id, String value) {
		super();
		this.id = id;
		this.value = value;
		this.flag = Flag.General;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
