package com.stackroute.activitystream.repository;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import com.stackroute.activitystream.config.HibernateUtil;
import com.stackroute.activitystream.model.Message;

/*
 * This class contains the code for database interactions and methods 
 * of this class will be used by other parts of the applications such
 * as Controllers and Test Cases
 * */
@Service
public class MessageRepository {

	Session session;

	public MessageRepository() {
		/*
		 * create a hibernate session from HibernateUtil
		 */
		session = getSession();
	}

	/*
	 * This method is used to save messages in database
	 */
	public boolean sendMessage(Message message) {
		if (null == message || null == session
				|| null == message.getSenderName()
				|| null == message.getMessage()
				|| message.getSenderName().isEmpty()
				|| message.getMessage().isEmpty()) {
			return false;
		}

		if(!session.isOpen()) {
			session = getSession();
		}
		if(!session.getTransaction().isActive()) {
			session.beginTransaction();
		}
		session.save(message);
		session.getTransaction().commit();
		return true;
	}

	/*
	 * This method is used to retrieve all messages in database
	 */
	public List<Message> getAllMessages() {
		//Criteria criteria = session.createCriteria(Message.class);
		if(!session.isOpen()) {
			session = getSession();
		}
		
		if(!session.getTransaction().isActive()) {
			session.beginTransaction();
		}		
        List<Message> list = session.createQuery("from Message").list();
        return list;
	}

	public static Session getSession() throws HibernateException {
		Session sess = null;
		try {
			sess = HibernateUtil.getSessionFactory().getCurrentSession();
		} catch (org.hibernate.HibernateException ex) {
			sess = HibernateUtil.getSessionFactory().openSession();
		}
		return sess;
	}
}
