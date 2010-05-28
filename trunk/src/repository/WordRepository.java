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

public class WordRepository {

	private List<Word> list;
	private Session session;

	public WordRepository() {

		list = new ArrayList<Word>();

		session = null;
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		session = sessionFactory.openSession();

		try {

			String sql = "select w.id, w.value, w.flag from Word w";

			Query query = session.createQuery(sql);

			Iterator it = query.iterate();
			while (it.hasNext()) {
				Object[] row = (Object[]) it.next();
				list.add(new Word(row));
			}
			

			
		} catch (Exception e) {
			System.out.println("Word Repository exception " + e.getMessage());
		}
	}

	public List<Word> getList() {
		return this.list;
	}

}
