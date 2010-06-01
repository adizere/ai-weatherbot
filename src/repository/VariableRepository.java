package repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.jdbc.object.SqlQuery;

import model.Domain;
import model.Variable;
import model.Word;

public class VariableRepository {

	private List<Variable> listV;
	private List<Domain> listD;
	private Session session;
	
	
	public VariableRepository() {

		listV = new ArrayList<Variable>();

		session = null;
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		session = sessionFactory.openSession();

		try {
			
			
			String sql = "select {domain.*} from Domain domain";
            
	        SQLQuery query = session.createSQLQuery(sql);
	        query.addEntity("domain", Domain.class);
	        listD = query.list();
	        
	        Iterator<Domain> it = listD.iterator();
//	        while(it.hasNext()){
//	        	List<Variable> lv = it.next().getVariables();
//	        	Iterator<Variable> it2 = lv.iterator();
//	        	while(it2.hasNext()){
//	        		Variable v = it2.next();
//	        		if (v != null)
//	        			listV.add(v);
//	        	}
//	        }
			
		} catch (Exception e) {
			System.out.println("Word Repository exception: " + e.getMessage());
		}
	}

	public List<Variable> getAllVariables() {
		return this.listV;
	}
	
	public List<Domain> getAllDomains() {
		return this.listD;
	}
}
