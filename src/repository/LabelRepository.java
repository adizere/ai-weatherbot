package repository;

import java.util.ArrayList;
import java.util.List;


import model.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LabelRepository {

	
	private List<Label> list;
	private Session session;
	
	
	
	public LabelRepository() {

		list = new ArrayList<Label>();

		session = null;
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		session = sessionFactory.openSession();
		
		try {
			
			Transaction tx = session.beginTransaction();
			
//			Label l = new Label(1, 2);
			
//			session.save(l);
			
			tx.commit();
			
		}catch(Exception e){
			System.out.println("LabelRepository Error: " + e.getMessage());
		}
	}
}
