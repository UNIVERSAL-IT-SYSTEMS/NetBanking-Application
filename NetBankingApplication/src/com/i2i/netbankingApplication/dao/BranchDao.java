package com.i2i.netbankingApplication.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.i2i.netbankingApplication.exception.DataBaseException;
import com.i2i.netbankingApplication.hibernateConnection.HibernateConnection;
import com.i2i.netbankingApplication.model.Branch;


public class BranchDao {
	 HibernateConnection hibernateConnectionObject  = HibernateConnection.getInstance();	
	 Configuration configuration = hibernateConnectionObject.getConfiguration();
	 SessionFactory sessionFactory = hibernateConnectionObject.getSessionFactory();
	 
	 public void addBranch(Branch branch) throws DataBaseException {
	     Session session = sessionFactory.openSession();
	     Transaction transaction = null;
	     try {
	         transaction = session.beginTransaction();
	         System.out.println(branch.getEmailId());
	         System.out.println(branch.getIFSCode());
	         System.out.println("hai1");
	        // session.savebranch.setIFSCode());
		     session.save(branch); 
		     System.out.println("hai2");
	         transaction.commit();                                                                    
		 } catch (HibernateException e) {
			 throw new DataBaseException("PLEASE CHECK YOUR DATAS " + branch + " YOUR DATA IS NOT VALID.PLEASE TRY AGAIN." );  
	     } finally {
	         session.close(); 
	     }
	 }
	 public void deleteBranchById(String ifsc) throws DataBaseException {
	     Session session = sessionFactory.openSession();
	     Transaction transaction = null;
	     try {
	         transaction = session.beginTransaction();
	         Branch branch = (Branch)session.get(Branch.class, ifsc); 
	         session.delete(branch); 
	         transaction.commit();
	     } catch (HibernateException e) {
	    	 throw new DataBaseException("CHECK IFSC " + ifsc + "PLEASE INSERT VALID IFSC...\n");  
	     } finally {
	         session.close(); 
	     }
     }
	 public Branch retrieveBranchById(String ifsc) throws DataBaseException {
	     Branch branch = null ;
	     Session session = sessionFactory.openSession();
	     Transaction transaction = null;
	     try {
	         transaction = session.beginTransaction();
	         branch = (Branch)session.get(Branch.class, ifsc); 
	         transaction.commit();
	     } catch (HibernateException e) {
	    	 throw new DataBaseException("CHECK IFSC " + ifsc + "PLEASE INSERT VALID IFSC...\n");
	     } finally {
	         session.close(); 
	     } 
	     return branch; 
	 }
	 public List<Branch> retriveAllBranch() throws DataBaseException {
	     Session session = sessionFactory.openSession();
	     Transaction transaction = null;
	     try {
	         transaction = session.beginTransaction();
	         return session.createQuery("FROM Branch").list();
	     } catch (HibernateException e) {
	         throw new DataBaseException("DATA IS NOT AVAILABLE.INSERT DATA.");
	     } finally {
	         session.close();
	     }
	 }
}
