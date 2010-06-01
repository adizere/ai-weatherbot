package repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.PredicateAdaptor;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PredicateAdaptorRepository {
	
	private List<PredicateAdaptor> list;
	private Session session;
	
	public PredicateAdaptorRepository(){
		
		list = new ArrayList<PredicateAdaptor>();
		
		session = null;
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		session = sessionFactory.openSession();
		
		try {
			
			String sql = "select p.id, p.variable_id, p.domain_id, p.predicate_id from PredicateAdaptor p";
			
			Query query = session.createQuery(sql);
			
			Iterator it = query.iterate();
			while (it.hasNext()) {
				Object[] row = (Object[]) it.next();
				list.add(new PredicateAdaptor(row));
			}
			
		}catch(Exception e){
			System.out.println("PredicateRepository Error: " + e.getMessage());
		}
		
	}

	public List<PredicateAdaptor> getList() {
		return list;
	}

	public void setList(List<PredicateAdaptor> list) {
		this.list = list;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
	
	public PredicateAdaptor findById(long id){
		for(PredicateAdaptor pa:list)
			if(pa.getId() == id)
				return pa;
		return null;
	}
}
