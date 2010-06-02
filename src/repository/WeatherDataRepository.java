package repository;

import java.util.ArrayList;
import java.util.Iterator;
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

			
			List<WeatherData> secondaryList = new ArrayList<WeatherData>();
			WeatherData weatherData;
			
			for (int i=0; i<list.size(); i++){

				List<Label> listLabel = new ArrayList<Label>();
				listLabel = lr.getList();
				
				for (int j=0; j<listLabel.size(); j++){
					Label label = listLabel.get(j);
					
					if (label != null && label.getId() == list.get(i).getLabel_id()){
						if (list.get(i).getLabel() == null){
							list.get(i).setLabel(label);
							listLabel.set(j, null);
						}						
						else{
							weatherData = new WeatherData(list.get(i));
							weatherData.setLabel(label);
							listLabel.set(j, null);
							secondaryList.add(weatherData);
						}
					}	
				}
			}
			
			for (int i=0; i<secondaryList.size(); i++)
				list.add(secondaryList.get(i));
			
			for (int i = 0; i < list.size(); i++) {
				Timeline t = tr.findByID(list.get(i).getTimeline_id());
				if (t != null)
					list.get(i).setTimeline(t);
			}
			
		}catch (Exception e) {
			System.out.println("weatherData Repo exception: " + e.getMessage());
		}
	}


	public List<WeatherData> getAll() {
		return list;
	}
	
}
