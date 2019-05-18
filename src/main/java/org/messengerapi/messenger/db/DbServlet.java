package org.messengerapi.messenger.db;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.messengerapi.messenger.model.Message;

public class DbServlet extends HttpServlet {
	
	private static Map<Integer, Message> messages=DataBase.getMessages();
	 
	public static Map<Integer, Message> getMessages() {
		return messages;
	}

	public static void setMessages(Map<Integer, Message> messages) {
		DbServlet.messages = messages;
	}

	public void init() throws ServletException
	    {	
		 System.out.println("intializing stub DB");
		    Message m1=new Message(1,"message1","pranjal");
			Message m2=new Message(2,"message2","pranjal");
			Message m3=new Message(3,"message3","pranjal");
			Message m4=new Message(4,"message4","pranjal");
			Message m5=new Message(5,"message5", "pranjal");
			Message m6=new Message(6,"message6", "suraj");
			Message m7=new Message(7,"message7", "sourabh");
			Message m8=new Message(8,"message8", "sorabh");
			
			messages.put(1,m1);
			messages.put(2,m2);
			messages.put(3,m3);
			messages.put(4,m4);
			messages.put(5,m5);
			messages.put(6,m6);
			messages.put(7,m7);
			messages.put(8,m8);
			
			
	    }
	

}
