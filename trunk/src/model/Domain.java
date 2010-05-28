package model;

public class Domain {
	
	private long id;
	
	private static final double EPSILON = 1e-2;
	private double lowerBound;
	private double upperBound;
	
	
	
	/**
	 * @param id
	 * @param lowerBound
	 * @param upperBound
	 */
	public Domain(long id, double lowerBound, double upperBound) {
		super();
		this.id = id;
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}

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
		return (b-a)>(- EPSILON );
	}
	
	private boolean ge(double a, double b) // greater equal
	{
		return (a-b)>(-EPSILON );
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
}
