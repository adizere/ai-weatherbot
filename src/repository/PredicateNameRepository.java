package repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Domain;
import model.PredicateName;
import model.Variable;

public class PredicateNameRepository {
	
	private List<PredicateName> list = new ArrayList<PredicateName>();
	private Session session;
	
	public PredicateNameRepository() {
		session = null;
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		session = sessionFactory.openSession();
		
		try {
			
			Criteria criteria = session.createCriteria(PredicateName.class);
			list = criteria.list();
		
		}catch(Exception e){
			System.out.println("LabelRepository Error: " + e.getMessage());
		}
	}
	
	
	public PredicateName findById(long id){
		for(PredicateName pn:list)
			if(pn.getId() == id)
				return pn;
		
		return null;
	}
}
