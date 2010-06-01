package repository;

import java.util.ArrayList;
import java.util.List;

import model.Domain;
import model.Predicate;
import model.PredicateAdaptor;
import model.PredicateName;
import model.Variable;

public class PredicateRepository {
	
	private PredicateAdaptorRepository par;
	private DomainRepository dr;
	private VariableRepository vr;
	private PredicateNameRepository pnr;
	private long maxId = 1;
	
	private List<Predicate> predicates = new ArrayList<Predicate>();
	
	/**
	 * @param par
	 * @param dr
	 * @param vr
	 * @param pnr
	 */
	public PredicateRepository(PredicateAdaptorRepository par,
			DomainRepository dr, VariableRepository vr,
			PredicateNameRepository pnr) {
		super();
		this.par = par;
		this.dr = dr;
		this.vr = vr;
		this.pnr = pnr;
		this.populate();
	}

	private void populate(){

		Domain d;
		Variable v;
		PredicateName pn;

		for(PredicateAdaptor pa : par.getList()){

			d = dr.findById(pa.getDomain_id());
			v = vr.findById(pa.getVariable_id());
			pn = pnr.findById(pa.getPredicate_id());

			if( (d != null) && (v != null) && (pn!=null) ){
				
				Predicate p = this.findByName(pn.getName());
				if( p != null)
					p.put(v, d);
				else{
					p = new Predicate(pn.getName());
					p.setId(maxId);
					maxId ++;
					p.put(v, d);
					predicates.add(p);
				}
			}
		}

	}
	
	public Predicate findById(long id){
		for(Predicate p:this.predicates)
			if(p.getId() == id)
				return p;
		return null;
	}
	
	public Predicate findByName(String name){
		for(Predicate p:this.predicates)
			if(p.getName().equals(name))
				return p;
		return null;
	}

	public List<Predicate> getPredicates() {
		return predicates;
	}

	
}
