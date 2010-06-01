package model;

public class Label {

	private long id;
	
	private Variable variable;
	private long variable_id = 0;
	private Domain value;
	private long value_id = 0;
	
	
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
		this.id = 0;
		this.variable = variable;
		this.value = value;
	}
	
		
	/**
	 * 
	 */
	public Label() {
		super();
		this.id = 0;
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

	public long getVariable_id() {
		return variable_id;
	}

	public void setVariable_id(long variableId) {
		variable_id = variableId;
	}

	public long getValue_id() {
		return value_id;
	}

	public void setValue_id(long valueId) {
		value_id = valueId;
	}	
	
	
	@Override
	public String toString() {
		return "Label [id=" + id + ", value=" + value + ", variable="
				+ variable + "]";
	}
}
