/*package com.stackroute.activitystream.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stackroute.activitystream.dao.MessageDAO;
import com.stackroute.activitystream.model.Message;

@Repository("messageDAO")
@Transactional
public class MessageDAOImpl {

	private static int pageSize = 8;

	@Autowired
	private SessionFactory sessionFactory;

	
	public MessageDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public List<Message> getMessagesFromCircle() {
		Query query = getCurrentSession().createQuery("from Message order by postedDate desc");
		return query.list();
	}


	public boolean sendMessageToCircle(Message message) {
		try {
			message.setPostedDate();
			getCurrentSession().save(message);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}


}
*/