package com.iwe.avengers.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.iwe.avenger.dynamodb.entity.Avenger;
import com.iwe.avenger.dynamodb.manager.DynamoDBManager;

public class AvangerDAO {
	
	

	private DynamoDBMapper mapper = DynamoDBManager.mapper();
	
	
	public AvangerDAO() {
				
	}
	
	public Avenger find(String id) {	
		
		final Avenger avenger = mapper.load(Avenger.class,id);
		return Optional.ofNullable(avenger).get();
		
	}

	public Avenger create(Avenger newAvenger) {	
		
		mapper.save(newAvenger);
		return newAvenger;
	}


	public void update(Avenger avenger) {
		// null;
		
	}
	public void remove(String id) {
		//mapper.delete			
	}
}
