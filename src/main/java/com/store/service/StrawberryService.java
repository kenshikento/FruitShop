package com.store.service;

public class StrawberryService implements FruitService {
	   
	@Override
	public String getEndPoint() {
		return FruitType.STRAWBERRY.toString();
	}
 }