package com.eeit95.her.model.card;

import java.util.*;

public class MsgSelectCardBean  {
	
	private String message;
	private String success;
	private CardSelectAllBean data;
	
	
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
	public CardSelectAllBean getData() {
		return data;
	}
	public void setData(CardSelectAllBean data) {
		this.data = data;
	}
	

}