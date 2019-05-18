package org.messengerapi.messenger.model;

import java.util.Date;

public class Profile {

	private Integer id;
	private String profileName;
	private String lname;
	private String fname;
	private Date created;
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Integer getId() {
		return id;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	
	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	
	public Profile() {
		
	}
	
	public Profile(int id,String profileName, String fname, String lname) {
		//super();
		this.id=id;
		this.fname = fname;
		this.lname = lname;
		this.profileName=profileName;
		
	}
	
	
}
