package org.messengerapi.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.UriInfo;

import org.messengerapi.messenger.db.DataBase;
import org.messengerapi.messenger.exception.DataNotFoundException;
import org.messengerapi.messenger.model.*;
import org.messengerapi.messenger.resources.MessageResource;
import org.messengerapi.messenger.resources.ProfileResource;
public class MessageService {

	private Map<Integer, Message> messages;
	//private Map<Integer, Message> profile=new HashMap<>();
	
	public MessageService()
	{
		messages=DataBase.getMessages();
	}
	
	public List<Message> getAllMessages() {
		List<Message> list=new ArrayList<Message>(messages.values());
	/*	Message m1=new Message(1,"message1","pranjal");
		Message m2=new Message(2,"message2","pranjal");
		Message m3=new Message(3,"message3","pranjal");
		Message m4=new Message(4,"message4","pranjal");
		Message m5=new Message(5,"message5", "pranjal");
		Message m6=new Message(6,"message6", "suraj");
		Message m7=new Message(7,"message7", "sourabh");
		Message m8=new Message(8,"message8", "sorabh");
		list.add(m1);
		list.add(m2);
		list.add(m3);
		list.add(m4);
		list.add(m5);
		list.add(m6);
		list.add(m7);
		list.add(m8);*/
		return list;
	}
	
	public String getUriForComment(UriInfo uriInfo, Message msg) {
		String commnetsLink=uriInfo.getBaseUriBuilder().path(MessageResource.class, "getCommentResource")
				   .resolveTemplate("messageId", String.valueOf(msg.getId()))
				   .build().toString();
		return commnetsLink;
	}

	
    public String getUriForProfile(UriInfo uriInfo, Message msg) {
		String profileLink=uriInfo.getBaseUriBuilder().path(ProfileResource.class)
    													   .path(msg.getAuthor())
    													   .build().toString();
		return profileLink;
	}

	public	 String getUriForSelf(UriInfo uriInfo, Message msg) {
		String uri=uriInfo.getBaseUriBuilder().path(MessageResource.class)
												.path(String.valueOf(msg.getId()))
												.build().toString();
		return uri;
	}
	

	
	
	public Message getMessage(int id)
	{Message m=messages.get(id);
	if(m==null)
	{
		throw new DataNotFoundException("no message found for id "+id);
	}
	else
		return messages.get(id);
	}
	
	public ArrayList<Message> getYearMessage(int year)
	{
	ArrayList<Message> al=new ArrayList<Message>();
	Calendar cal=Calendar.getInstance();
	for(Message m: messages.values())
	{cal.setTime(m.getCreated());
	if(cal.get(Calendar.YEAR)==year) {al.add(m);		
	}
	}
	return al;
	}
		
	public List<Message> getMessagePaginated(int start, int size)
	{
		System.out.println("inside start end service");
		
	//ArrayList<Message> al=(ArrayList<Message>) messages.values();
		ArrayList<Message> al=new ArrayList(messages.values());
	//return (ArrayList<Message>) al.subList(start, size);
		return al.subList(start, size);
	}
	
	
	public Message addMessage(Message msg)
	{
		msg.setId(messages.size()+1);
		messages.put(msg.getId(), msg);
		return msg;
	}
	
	public Message updateMessage(Message msg)
	{
		if(msg.getId()<=0)
			return null;
		messages.put(msg.getId(), msg);
		return msg;
	}
	
	public Message removeMessage(int id) {
	return messages.remove(id);
		}
	}

