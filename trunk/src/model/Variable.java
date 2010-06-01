package model;

public class Variable implements Comparable<Variable>{
	
	private long id;
	
	private String name;	
	
	public Variable() {
		super();
		id = 0;
		name = "";
	}
	
	/**
	 * @param id
	 * @param name
	 * @param domain
	 */
	public Variable(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	/**
	 * @param name
	 * @param domain
	 */
	public Variable(String name) {
		super();
		this.id = 0;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public int compareTo(Variable arg0) {
		
		return this.getName().compareTo(arg0.getName());
	}

	@Override
	public String toString() {
		return "#" + this.id + "; " + this.name ;
	}
	
}
