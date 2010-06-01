package repository;

import java.util.ArrayList;
import java.util.List;


import model.*;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class WeatherDataRepository {

	private List<WeatherData> list;
	private Session session;
	
	
	public WeatherDataRepository() {
		list = new ArrayList<WeatherData>();

		session = null;
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		session = sessionFactory.openSession();
		
		try {

			Criteria criteria = session.createCriteria(WeatherData.class);
			list = criteria.list();

			
		}catch (Exception e) {
			System.out.println("weatherData Repo exception: " + e.getMessage());
		}
	}
}
