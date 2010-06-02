package model;

public class PredicateAdaptor {
	
	private long id;
	private long predicate_id;
	private long variable_id;
	private long domain_id;
	
	/**
	 * 
	 */
	public PredicateAdaptor() {
		super();
	}
	
	/**
	 * @param id
	 * @param predicateId
	 * @param variableId
	 * @param domainId
	 */
	public PredicateAdaptor(long id, long predicateId, long variableId,
			long domainId) {
		super();
		this.id = id;
		this.predicate_id = predicateId;
		this.variable_id = variableId;
		this.domain_id = domainId;
	}
	
	public PredicateAdaptor(Object[] obj){
		super();
		this.id =(Long) obj[0];
		this.predicate_id =(Long) obj[3];
		this.variable_id = (Long) obj[1];
		this.domain_id = (Long) obj[2];
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getPredicate_id() {
		return predicate_id;
	}
	
	public void setPredicate_id(long predicateId) {
		predicate_id = predicateId;
	}
	
	public long getVariable_id() {
		return variable_id;
	}
	
	public void setVariable_id(long variableId) {
		variable_id = variableId;
	}
	
	public long getDomain_id() {
		return domain_id;
	}
	
	public void setDomain_id(long domainId) {
		domain_id = domainId;
	}
}
