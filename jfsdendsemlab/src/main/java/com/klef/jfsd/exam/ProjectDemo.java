package com.klef.jfsd.exam;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class ProjectDemo {
	public static void main(String[] args) {
		ProjectDemo operations = new ProjectDemo();
		//operations.addProject();
		 operations.aggregatefunctions();
	}

	public void addProject() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();

		Transaction transaction = session.beginTransaction();

		Project p = new Project();
		p.setId(100);
		p.setName("JFSD");
		p.setDuration("30");
		p.setBudget(20000.0);
		p.setTeamLead("KLU");

		p.setId(102);
		p.setName("Python");
		p.setDuration("10");
		p.setBudget(50000.0);
		p.setTeamLead("Java");

		session.persist(p);
		transaction.commit();
		System.out.println("Project Added Successfully");

		session.close();
		sf.close();

	}

	
	public void aggregatefunctions() {
		Configuration cfg = new Configuration();
	     cfg.configure("hibernate.cfg.xml");
	     
	     SessionFactory sf = cfg.buildSessionFactory();
	     Session session = sf.openSession();
	     
	     CriteriaBuilder cb = session.getCriteriaBuilder();
	     CriteriaQuery<Double> cq = cb.createQuery(Double.class);
	     Root<Project> root = cq.from(Project.class);  
         cq.select(cb.sum(root.get("Budget")));
	     Double sum = session.createQuery(cq).getSingleResult();
	     System.out.println(sum);
//	    
//	     CriteriaBuilder cb = session.getCriteriaBuilder();
////	     CriteriaQuery<Double> cq = cb.createQuery(Double.class);
//	     Root<Project> root = cq.from(Project.class);  
//	     cq.select(cb.min(root.get("Budget")));
//	     Double min = session.createQuery(cq).getSingleResult();
//	     System.out.println(min);
	     
//	     CriteriaBuilder cb = session.getCriteriaBuilder();
//	     CriteriaQuery<Double> cq = cb.createQuery(Double.class);
//	     Root<Project> root = cq.from(Project.class);  
//	     cq.select(cb.max(root.get("Budget")));
//	     Double max = session.createQuery(cq).getSingleResult();
//         System.out.println(max);
	     
//	     CriteriaBuilder cb = session.getCriteriaBuilder();
//	     CriteriaQuery<Long> cq = cb.createQuery(Long.class);
//	     Root<Project> root = cq.from(Project.class);  
//	     cq.select(cb.countDistinct(root.get("Budget")));
//	     Long count = session.createQuery(cq).getSingleResult();
//	     System.out.println(count);
     
	     session.close();
	     sf.close();
	}
}
