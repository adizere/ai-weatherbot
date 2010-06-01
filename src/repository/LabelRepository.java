package repository;

import java.util.ArrayList;
import java.util.List;


import model.*;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LabelRepository {

	
	private List<Label> list;
	private Session session;
	private VariableRepository vr;
	private DomainRepository dr;
	
	
	public LabelRepository(VariableRepository vR, DomainRepository dR) {

		this.vr = vR;
		this.dr = dR;
		list = new ArrayList<Label>();

		session = null;
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		session = sessionFactory.openSession();
		
		try {
			
			Criteria criteria = session.createCriteria(Domain.class);
			list = criteria.list();
			for(int i = 0; i < list.size(); i++){
				Variable v = (Variable) session.load(Variable.class,list.get(i).getVariable_id());
				list.get(i).setVariable(v);
				Domain d = (Domain) session.load(Domain.class, list.get(i).getValue_id());
				list.get(i).setValue(d);
			}
			
		}catch(Exception e){
			System.out.println("LabelRepository Error: " + e.getMessage());
		}
	}


	public List<Label> getList() {
		return list;
	}


	public void setList(List<Label> list) {
		this.list = list;
	}


	public VariableRepository getVr() {
		return vr;
	}


	public void setVr(VariableRepository vr) {
		this.vr = vr;
	}


	public DomainRepository getDr() {
		return dr;
	}


	public void setDr(DomainRepository dr) {
		this.dr = dr;
	}
	
	
}
