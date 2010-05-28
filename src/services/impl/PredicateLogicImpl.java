package services.impl;

import java.util.List;

import model.Domain;
import model.Label;
import model.Predicate;
import services.PredicateLogic;

public class PredicateLogicImpl implements PredicateLogic{

	@Override
	public boolean evaluatePredicate(Predicate predicate, List<Label> labels) {
		
		if(predicate.isEmpty())
			return true;
		
		boolean mismatch = false;
		for(Label l:labels){
			
			Domain d = predicate.get(l.getVariable());
			
			if( d!= null ){
				
				if( ! d.hasSubdomain(l.getValue() ) ){
					mismatch = true;
					break;
				}
					
			}
		}
		
		return !mismatch;
	}

	

}
