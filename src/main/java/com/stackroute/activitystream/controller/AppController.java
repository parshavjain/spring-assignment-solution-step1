package com.stackroute.activitystream.controller;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.stackroute.activitystream.config.HibernateUtil;
import com.stackroute.activitystream.model.Message;

@Controller
public class AppController {

	@RequestMapping("/")
	public String index(ModelMap model) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Message order by postedDate desc");
		List<Message> messages= query.list();
		session.getTransaction().commit();
		session.close();
		model.addAttribute("messages", messages);
		return "index";
	}
	
	@RequestMapping("/sendMessage")
	public String sendMessage(@RequestParam("sender") String sender,@RequestParam("message") String messageContent, ModelMap model) {
		
		Message message=new Message();
		message.setSenderId(sender);
		message.setMessage(messageContent);
		message.setPostedDate();
		
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.save(message);
		session.getTransaction().commit();
		session.close();
		
		session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Message order by postedDate desc");
		List<Message> messages= query.list();
		session.getTransaction().commit();
		session.close();
		model.addAttribute("messages", messages);
		return "redirect:/";
	}
		

}
