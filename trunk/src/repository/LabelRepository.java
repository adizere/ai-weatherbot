package repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import model.*;

import org.hibernate.Criteria;
import org.hibernate.Query;
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
			
			String sql = "select label.id, label.variable_id, label.value_id from Label label";
			Query query = session.createQuery(sql);

			Iterator it = query.iterate();
			
			Object[] row;
			while (it.hasNext()){
				row = (Object[]) it.next();
				list.add(new Label(row));
			}
			for(int i = 0; i < list.size(); i++){
				Variable v = vr.findById(list.get(i).getVariable_id());
				list.get(i).setVariable(v);
				Domain d = dr.findById(list.get(i).getValue_id());
				list.get(i).setValue(d);
			}
			
			System.out.println("test");
		}catch(Exception e){
			System.out.println("LabelRepository Error: " + e.getMessage());
		}
	}


	public Label findByID(long labelId) {
		for (int i=0; i<list.size(); i++)
			if (list.get(i).getId() == labelId)
				return list.get(i);
		return null;
	}
	
	public List<Label> getList() {
		List<Label> l2 = new ArrayList<Label>();
		for (int i=0; i<list.size(); i++)
			l2.add(list.get(i));
		return l2;
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
