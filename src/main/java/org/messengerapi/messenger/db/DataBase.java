package org.messengerapi.messenger.db;
import java.util.HashMap;
import java.util.Map;

import org.messengerapi.messenger.model.*;
public class DataBase {
	
	static private Map<Integer,Message> messages=new HashMap<>();
	static private Map<String,Profile> profiles=new HashMap<>();
	public static Map<Integer, Message> getMessages() {
		return messages;
	}
	public static void setMessages(Map<Integer, Message> messages) {
		DataBase.messages = messages;
	}
	public static Map<String, Profile> getProfiles() {
		return profiles;
	}
	public static void setProfiles(Map<String, Profile> profiles) {
		DataBase.profiles = profiles;
	}
	
	
	
}
