package model;

public class Variable {
	
	private String name;
	private Domain domain;
	
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
	
}
