/***************************************************************************
 * Copyright 2016 by HomeDirect - All rights reserved.                *    
 **************************************************************************/
package com.homedirect.template.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *  Author : Nhu Dinh Thuan
 *          Email:thuan.nhu@homedirect.com.vn
 * Nov 15, 2017
 */
@Entity
@Table(name = "`user`")
public class User {

	public final static int DIABLE = -1;
	public final static int NONE = 0;
	public final static int ACTIVE = 1;

	private String username;

	private String phone;

	private String password;

	private String fullname;

	private String email;

	private long creationDate;

	private long modificationDate;

	private int status;

	@Id
	public String getUsername() {  return username; }
	public void setUsername(String username) { this.username = username; }

	public String getPhone() { return phone; }
	public void setPhone(String phone) { this.phone = phone; }

	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }

	public String getFullname() { return fullname; }
	public void setFullname(String fullname) { this.fullname = fullname; }

	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }

	public long getCreationDate() { return creationDate; }
	public void setCreationDate(long creationDate) { this.creationDate = creationDate; }

	public long getModificationDate() { return modificationDate; }
	public void setModificationDate(long modificationDate) { this.modificationDate = modificationDate; }

	public int getStatus() { return status; }
	public void setStatus(int status) {  this.status = status; }
	
	@Override
	public String toString() {
		return "User [username=" + username + ", phone=" + phone + ", password=" + password + ", fullname=" + fullname
				+ ", email=" + email + ", creationDate=" + creationDate + ", modificationDate=" + modificationDate
				+ ", status=" + status + "]";
	}

}
