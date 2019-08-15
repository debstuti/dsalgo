package org.debstuti.controller;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.debstuti.controller.model.Message;
import org.glassfish.jersey.client.ClientConfig;

public class UserClient {
	public static void main(String[] args){
		getMessageById();
	}
	public static void getMessageById(){
		Client client = ClientBuilder.newClient( new ClientConfig().register( UserClient.class ));
		WebTarget webTarget = client.target("http://localhost:8080/messenger/messages").path("1");
		 
		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		 
		Message message = response.readEntity(Message.class);
		System.out.println(message);
		
		 
	}
}
