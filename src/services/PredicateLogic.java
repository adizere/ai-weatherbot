package services;

import model.Predicate;
import java.util.List;
import model.Label;

public interface PredicateLogic {
	
	public boolean evaluatePredicate(Predicate predicate, List<Label> labels);

}
