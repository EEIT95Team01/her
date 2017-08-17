package com.eeit95.her.model.gift;

import javax.persistence.Entity;

@Entity
public class MsgBean  {
	private String message;
	private String success;
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	

}
