package org.debstuti.messenger.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.debstuti.messenger.model.Message;

public class MessageService {
	private static Map<Long, Message> messages= new HashMap<Long,Message>();
	private static int count=0;
	public MessageService(){
		
	}
	public List<Message> getAllMessages(){
		
		return  new ArrayList<Message>(messages.values());
	}
	
	public Message getMessageById(long id){
		if(messages.containsKey(id)){
			return messages.get(id);
		}
		return null;
	}
	
	public Message createMessage(Message message){
		message.setId(++count);
		Date date = new Date();
		message.setCreatedOn(date);
		message.setModifiedOn(date);
		messages.put(message.getId(),message);
		System.out.println(message+" "+messages.size());
		return message;
	}
	public Message updateMessage(Message message){
		if(!messages.containsKey(message.getId())){
			return null;
		}
		Message msg = new Message(message);
		messages.put(msg.getId(), msg);
		return message;
	}
}
