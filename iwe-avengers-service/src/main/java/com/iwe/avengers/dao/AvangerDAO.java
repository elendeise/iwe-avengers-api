package com.iwe.avengers.dao;

import java.util.HashMap;
import java.util.Map;

import com.iwe.avenger.dynamodb.entity.Avenger;

public class AvangerDAO {
	
	public Map<String, Avenger> mapper = new HashMap<>();	

	
	public AvangerDAO() {
		mapper.put("sdsa-sasa-asas-sasa", new Avenger("sdsa-sasa-asas-sasa", "Iron Man", "Tony Stark")) ;
		mapper.put("aaaa-aaaa-aaaa-aaaa", new Avenger("aaaa-aaaa-aaaa-aaaa", "Hulk", "Bruce Banner")) ;
		mapper.put("aaaa-aaaa-aaaa-bbbb", new Avenger("aaaa-aaaa-aaaa-bbbb", "Spider-man", "Peter Parker")) ;
	}
	
	public Avenger find(String id) {	
		return mapper.get(id);
	}

	public Avenger create(Avenger newAvenger) {	
		String id = mapper.size() + "";	
		newAvenger.setId(id);		
		mapper.put(id, newAvenger);		
		
		return newAvenger;
	}

	public void remove(Avenger avenger) {
		mapper.remove(avenger.getId());		
	}

	public void update(Avenger avenger) {
		mapper.replace(avenger.getId(), avenger);		
	}
}
