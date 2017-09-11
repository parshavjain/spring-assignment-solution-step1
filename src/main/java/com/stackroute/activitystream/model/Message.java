package com.stackroute.activitystream.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="message")
public class Message {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int messageId;
	private String senderId;
	private Timestamp postedDate;
	private String message;
		
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public String getSenderId() {
		return senderId;
	}
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}
	
	public Timestamp getPostedDate() {
		return postedDate;
	}
	public void setPostedDate() {
		this.postedDate = setCurrentDate();
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public Timestamp setCurrentDate()
	{
		return new Timestamp(System.currentTimeMillis());
	}

}
