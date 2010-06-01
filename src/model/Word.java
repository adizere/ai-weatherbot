package model;

public class Word {
	
	private long id;
	
	private String value;
	private String flag;
	/**
	 * @param id
	 * @param value
	 */
	public Word(long id, String value) {
		super();
		this.id = id;
		this.value = value;
	}
	
	/**
	 * @param id
	 * @param value
	 * @param flag
	 */
	public Word(long id, String value, String flag) {
		super();
		this.id = id;
		this.value = value;
		this.flag = flag;
	}
	
	public Word(Object[] obj) {
		this(Long.parseLong(obj[0].toString()), obj[1].toString(), obj[2].toString());
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
	
	public String getFlag() {
		return flag;
	}
	
	public void setFlag(String flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "[ " + this.getId() + "; " + this.getValue() + "; " + this.flag + " ] ";
	}	
	

}
