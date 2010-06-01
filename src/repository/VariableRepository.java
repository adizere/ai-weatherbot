package repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.jdbc.object.SqlQuery;

import model.Domain;
import model.Timeline;
import model.Variable;
import model.Word;

public class VariableRepository {

	private List<Variable> list;
	private Session session;
	
	
	public VariableRepository() {

		list = new ArrayList<Variable>();

		session = null;
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		session = sessionFactory.openSession();

		try {
			
			Criteria criteria = session.createCriteria(Variable.class);
			list = criteria.list();
			
		} catch (Exception e) {
			System.out.println("Variable Repository exception: " + e.getMessage());
		}
	}

	public List<Variable> getAllVariables() {
		return this.list;
	}
	
}
