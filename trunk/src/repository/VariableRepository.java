package repository;

import java.util.ArrayList;
import java.util.List;

import model.Variable;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class VariableRepository {

	private List<Variable> list;
	private Session session;
	
	
	public VariableRepository() {

		list = new ArrayList<Variable>();

		session = null;
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		session = sessionFactory.openSession();

		try {
			
			Criteria criteria = session.createCriteria(Variable.class);
			list = criteria.list();
			
		} catch (Exception e) {
			System.out.println("Variable Repository exception: " + e.getMessage());
		}
	}

	public List<Variable> getAllVariables() {
		return this.list;
	}
	
	public Variable findById(long id){
		for(Variable v:list)
			if(v.getId() == id)
				return v;
		return null;
	}
}
