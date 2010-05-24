package model;

public class Label {
	
	private Variable variable;
	private double value;
	
	/**
	 * @param variable
	 * @param value
	 */
	public Label(Variable variable, double value) {
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

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	
	
}
