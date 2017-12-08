package com.stackroute.activitystream.repository;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import com.stackroute.activitystream.config.HibernateUtil;
import com.stackroute.activitystream.model.Message;

/**
 * This class contains the code for database interactions and methods of this
 * class will be used by other parts of the applications such as Controllers and
 * Test Cases
 */
@Service
public class MessageRepository {

	/**
	 * create sesson object.
	 */
	Session session;

	public MessageRepository() {
		/**
		 * create a hibernate session from HibernateUtil
		 */
		session = getSession();
	}

	/**
	 * This method is used to save messages in database
	 */
	public boolean sendMessage(Message message) {
		if (null != message && null != session && null != message.getSenderName() && null != message.getMessage()
				&& !message.getSenderName().isEmpty() && !message.getMessage().isEmpty()) {
			session = getSession();
			session.beginTransaction();
			session.save(message);
			session.getTransaction().commit();
			return true;
		}

		return false;
	}

	/**
	 * This method is used to retrieve all messages in database
	 */
	@SuppressWarnings("unchecked")
	public List<Message> getAllMessages() {
		// Criteria criteria = session.createCriteria(Message.class);
		session = getSession();
		session.beginTransaction();
		List<Message> list = session.createQuery("from Message order by senderName").list();
		return list;
	}

	/**
	 * getSession()
	 */
	public static Session getSession() throws HibernateException {
		Session sess = null;
		try {
			sess = HibernateUtil.getSessionFactory().getCurrentSession();
		} catch (org.hibernate.HibernateException ex) {
			// sess = HibernateUtil.getSessionFactory().openSession();
			ex.getStackTrace();
		}
		return sess;
	}
}
