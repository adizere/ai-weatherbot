package repository;

import java.util.ArrayList;
import java.util.List;


import model.*;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DomainRepository {

	
	private List<Domain> list;
	private Session session;
	
	
	
	public DomainRepository() {

		list = new ArrayList<Domain>();

		session = null;
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		session = sessionFactory.openSession();
		
		try {
			
			
			Criteria criteria = session.createCriteria(Domain.class);
			list = criteria.list();
			
		}catch(Exception e){
			System.out.println("Domain Repo Error: " + e.getMessage());
		}
	}



	public List<Domain> getAll() {
		return this.list;
	}
}
