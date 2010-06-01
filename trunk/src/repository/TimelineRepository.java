package repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
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

		try {

			String sql = "select from Timeline timeline";

			Criteria criteria = session.createCriteria(Timeline.class);
			list = criteria.list();

		} catch (Exception e) {
			System.out.println("TimelineRepository exception: "
					+ e.getMessage());
		}
	}

	public List<Timeline> getAll() {
		return list;
	}
}
