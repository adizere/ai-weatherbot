package model;

public class Label {
	
	private long id;
	
	private Variable variable;
	private Domain value;
	
	
	/**
	 * @param id
	 * @param variable
	 * @param value
	 */
	public Label(long id, Variable variable, Domain value) {
		super();
		this.id = id;
		this.variable = variable;
		this.value = value;
	}
	
	/**
	 * @param variable
	 * @param value
	 */
	public Label(Variable variable, Domain value) {
		super();
		this.variable = variable;
		this.value = value;
	}
	
	public Variable getVariable() {
		return variable;
	}
	
	public void setVariable(Variable variable) {
		this.variable = variable;
	}
	
	public Domain getValue() {
		return value;
	}
	
	public void setValue(Domain value) {
		this.value = value;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
			
}
