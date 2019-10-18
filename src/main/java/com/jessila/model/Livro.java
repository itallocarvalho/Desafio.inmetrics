package com.jessila.model;

import java.io.Serializable;
import java.util.Date;


public class Livro implements Serializable{

	private static final long serialVersionUID = -8661027939970598113L;

	private Integer id;
	private String title;
	private String description;
	private Integer pageCount;
	private String excerpt;
	private Date publishDate;

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
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getPageCount() {
		return this.pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public String getExcerpt() {
		return this.excerpt;
	}
	public void setExcerpt(String excerpt) {
		this.excerpt = excerpt;
	}
	public Date getPublishDate() {
		return this.publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	@Override
	public String toString() {
		return "Livro [id=" + this.id + ", title=" + this.title + ", description=" + this.description + ", pageCount=" + this.pageCount
				+ ", excerpt=" + this.excerpt + ", publishDate=" + this.publishDate + "]";
	}


}
