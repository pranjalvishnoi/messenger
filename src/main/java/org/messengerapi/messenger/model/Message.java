package org.messengerapi.messenger.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Message {
	private int id;
	private String message;
	private Date created;
	private String author;
	private Map<Integer, Comment> comments=new HashMap<>();
	List<Link> linklist=new ArrayList<>();
	
	@XmlTransient
	public Map<Integer, Comment> getComments() {
		return comments;
	}
	

	public List<Link> getLinklist() {
		return linklist;
	}


	public void setLinklist(List<Link> linklist) {
		this.linklist = linklist;
	}


	public void setComments(Map<Integer, Comment> comments) {
		this.comments = comments;
	}

	public Message() {
		
	}
	
	public Message(int id, String message, String author) {
		//super();
		this.id = id;
		this.message = message;
		this.created = new Date();  //pick current date
		this.author = author;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void addLink(String url, String rel)
	{
		Link link=new Link();
		link.setLink(url);
		link.setRelation(rel);
		linklist.add(link);
	}
	

}
