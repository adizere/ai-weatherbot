package repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Timeline;
import model.Variable;

public class TimelineRepository {

	private List<Timeline> list;
	private Session session;
	
	
	public TimelineRepository() {
		
		list = new ArrayList<Timeline>();

		session = null;
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		session = sessionFactory.openSession();
		
		try{
			
			Transaction tx = session.beginTransaction();
			
			Timeline t = new Timeline(Calendar.getInstance(), Calendar.getInstance());
			
			session.save(t);
			
			tx.commit();
			
		}catch (Exception e) {
			System.out.println("TimelineRepository exception: " + e.getMessage());
		}
	}
	
}
