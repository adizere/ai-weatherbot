package model;

public class Label {
	
	private Variable variable;
	private Domain value;
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
	
	
	
		
}
