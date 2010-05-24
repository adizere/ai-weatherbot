package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Predicate extends TreeMap<Variable, Domain> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2852864952404104308L;
	private String name = "default";
	private List<Predicate> subPredicates = new ArrayList<Predicate>();
	
	/**
	 * 
	 */
	public Predicate() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param arg0
	 */
	public Predicate(Comparator<? super Variable> arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param arg0
	 */
	public Predicate(Map<? extends Variable, ? extends Domain> arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param arg0
	 */
	public Predicate(SortedMap<Variable, ? extends Domain> arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param name
	 */
	public Predicate(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Predicate> getSubPredicates() {
		return subPredicates;
	}
	
	public void setSubPredicates(List<Predicate> subPredicates) {
		this.subPredicates = subPredicates;
	}
	
}
