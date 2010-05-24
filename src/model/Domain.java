package model;

public class Domain {
	
	private static final double EPSILON = 1e-4;
	private double lowerBound;
	private double upperBound;
	
	/**
	 * @param lowerBound
	 * @param upperBound
	 */
	public Domain(double lowerBound, double upperBound) {
		super();
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}

	public double getLowerBound() {
		return lowerBound;
	}

	public void setLowerBound(double lowerBound) {
		this.lowerBound = lowerBound;
	}

	public double getUpperBound() {
		return upperBound;
	}

	public void setUpperBound(double upperBound) {
		this.upperBound = upperBound;
	}
	
	public boolean belongs(double value){
		return ( ge(value,lowerBound) && se(value,upperBound) );
	}
	
	public boolean hasSubdomain(Domain subdomain){
		return ge(subdomain.getLowerBound() , this.lowerBound) && se(subdomain.getUpperBound() , this.upperBound);
	}
	
	private boolean se(double a, double b) // smaller equal
	{
		return (b-a)>EPSILON;
	}
	
	private boolean ge(double a, double b) // greater equal
	{
		return (a-b)>EPSILON;
	}
}
