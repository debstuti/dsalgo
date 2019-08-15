package org.debstuti.profile.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.debstuti.profile.model.Profile;

public class ProfileService {
	private static Map<String, Profile> profiles = new HashMap<String, Profile>();
	
	public Profile createProfile(Profile profile){
		profiles.put(profile.getName(), profile);
		return profiles.get(profile.getName());
	}
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	public Profile getProfileByName(String name){
		return profiles.get(name);
	}
}
