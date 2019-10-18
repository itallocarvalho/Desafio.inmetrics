package com.jessila.model;

import java.io.Serializable;

public class Atividade implements Serializable{

	private static final long serialVersionUID = 8641286078006156219L;

	public Integer userId;
	public Integer id;
	public String title;
	public boolean completed;

	public Integer getUserId() {
		return this.userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public boolean isCompleted() {
		return this.completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}


}
