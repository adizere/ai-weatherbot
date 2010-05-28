package model;

public class Variable implements Comparable<Variable>{
	
	private long id;
	
	private String name;
	private Domain domain;
	
	
	/**
	 * @param id
	 * @param name
	 * @param domain
	 */
	public Variable(long id, String name, Domain domain) {
		super();
		this.id = id;
		this.name = name;
		this.domain = domain;
	}

	/**
	 * @param name
	 * @param domain
	 */
	public Variable(String name, Domain domain) {
		super();
		this.name = name;
		this.domain = domain;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Domain getDomain() {
		return domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
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
	
}
