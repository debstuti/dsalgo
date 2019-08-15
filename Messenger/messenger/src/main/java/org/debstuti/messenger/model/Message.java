package org.debstuti.messenger.model;


import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message{
	private long id;
	private String content;
	private String author;
	private Date createdOn;
	private Date modifiedOn;
	public Message(){ // we need default constructor otherwise jersey throws error (needed for conversion)
		
	}
	public Message(int id, String content, String author){
		this.id=id;
		this.content=content;
		this.author=author;
		this.createdOn=new Date();
		this.modifiedOn=new Date();
	}
	public Message(Message message){
		message.setModifiedOn(new Date());
		
	}
	@Override
	public String toString(){
		return this.getId()+" "+this.getAuthor()+" "+this.getContent()+" "+this.getCreatedOn()+" "+this.getModifiedOn();
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getId() {
		return id;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String writer) {
		this.author = writer;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public Date getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	
	
	
}
