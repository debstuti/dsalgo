package org.debstuti.profile.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.debstuti.profile.model.Profile;
import org.debstuti.profile.service.ProfileService;

@Path("profiles")
public class ProfileResource {
	
	ProfileService profileSrvc = new ProfileService();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Profile createProfile(Profile profile){
		return profileSrvc.createProfile(profile);
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Profile> getAllProfiles(){
		System.out.println("get");
		return profileSrvc.getAllProfiles();
	}
	
	@GET
	@Path("{profileName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Profile getProfileByName(@PathParam("profileName") String profileName){
		
		return profileSrvc.getProfileByName(profileName);
	}
	
}
