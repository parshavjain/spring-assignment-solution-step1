package com.stackroute.activitystream.test;
import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.stackroute.activitystream.config.HibernateUtil;
import com.stackroute.activitystream.model.Message;

public class ActivityStreamTest {

	Session session=null;
	
	
	@Before
	public void setup() {
		session=HibernateUtil.getSessionFactory().openSession();
		
	}
	
	@After
	public void teardown() {
		
		session.close();
		
	}
	
	@Test
	public void testGetListOfMessages() {
		session.beginTransaction();
		Query query = session.createQuery("from Message order by postedDate desc");
		List<Message> messages= query.list();
		session.getTransaction().commit();
		assertNotNull("Retrieval of messages failed.",messages);
	}
	
	@Test
	public void testSendMessages() {
		
		Message message=new Message();
		message.setSenderId("John");
		message.setMessage("Sample message");
		message.setPostedDate();
		
		session.beginTransaction();
		session.save(message);
		session.getTransaction().commit();
		
		session.beginTransaction();
		Query query = session.createQuery("from Message order by postedDate desc");
		List<Message> messages= query.list();
		session.getTransaction().commit();
		
		boolean found=false;
		for(Message msg:messages)
		{
			if(msg.getSenderId().equals("John") && msg.getMessage().equals("Sample message")) {
				found=true;
			}
		}
		
		assertEquals("Sending of messages failed",true,found);
		
		session.beginTransaction();
		session.delete(message);
		session.getTransaction().commit();
			
	}
	

}
