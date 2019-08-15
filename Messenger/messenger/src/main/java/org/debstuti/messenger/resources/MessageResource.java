package org.debstuti.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.debstuti.messenger.model.Message;
import org.debstuti.messenger.service.MessageService;

@Path("messages")
public class MessageResource {
	MessageService msgService = new MessageService();
	public static int count=0;
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(){
		
		return msgService.getAllMessages();
		
		
	}
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessageBuId(@PathParam("messageId") long messageId){
		
		return msgService.getMessageById(messageId);
		
		
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message createMessage(Message message){
		return msgService.createMessage(message);
	}
	
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message updateMessage(Message message){
		return msgService.updateMessage(message);
	}
}
