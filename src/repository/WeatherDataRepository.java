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
	private LabelRepository lr;
	private TimelineRepository tr;
	
	
	public WeatherDataRepository(LabelRepository lr, TimelineRepository tr) {
		
		this.lr = lr;
		this.tr = tr;
		
		list = new ArrayList<WeatherData>();

		session = null;
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		session = sessionFactory.openSession();
		
		try {

			Criteria criteria = session.createCriteria(WeatherData.class);
			list = criteria.list();

			for (int i=0; i<list.size(); i++){
				Label l = lr.findByID(list.get(i).getLabel_id());
				if (l != null)
					list.get(i).setLabel(l);
				
				Timeline t = tr.findByID(list.get(i).getTimeline_id());
				if (t != null)
					list.get(i).setTimeline(t);
			}
			
		}catch (Exception e) {
			System.out.println("weatherData Repo exception: " + e.getMessage());
		}
	}
	
}
