package model;

public class PredicateName {
	
	private long id;
	private String name;
	
	/**
	 * 
	 */
	public PredicateName() {
		super();
		id = 0;
		name = "";
	}
	
	/**
	 * @param id
	 * @param name
	 */
	public PredicateName(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "PredicateName [id=" + id + ", name=" + name + "]";
	}
}
