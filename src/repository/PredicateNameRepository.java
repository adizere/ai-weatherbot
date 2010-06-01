package repository;

import java.util.ArrayList;
import java.util.List;

import model.PredicateName;

public class PredicateNameRepository {
	
	private List<PredicateName> list = new ArrayList<PredicateName>();
	
	
	public PredicateName findById(long id){
		for(PredicateName pn:list)
			if(pn.getId() == id)
				return pn;
		
		return null;
	}
}
