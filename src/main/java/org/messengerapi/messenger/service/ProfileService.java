package org.messengerapi.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.messengerapi.messenger.db.DataBase;
import org.messengerapi.messenger.model.Message;
import org.messengerapi.messenger.model.Profile;

public class ProfileService {

	private Map<String, Profile> profiles;
	//private Map<Integer, Message> profile=new HashMap<>();
	
	public ProfileService()
	{
		profiles=DataBase.getProfiles();
	}
	
	public List<Profile> getAllProfiles() {
		List<Profile> list=new ArrayList<Profile>(profiles.values());
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
	
	public Profile getProfile(String profileName)
	{
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile prof)
	{
		prof.setId(profiles.size()+1);
		profiles.put(prof.getProfileName(), prof);
		return prof;
	}
	
	public Profile updateProfile(Profile prof)
	{
		if(prof.getProfileName().isEmpty())
			return null;
		profiles.put(prof.getProfileName(), prof);
		return prof;
	}
	
	public Profile removeProfile(String profileName) {
	return profiles.remove(profileName);
		}
	

}
