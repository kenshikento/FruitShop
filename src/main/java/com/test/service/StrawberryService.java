package com.test.service;

public class StrawberryService implements FruitService {
	   
	public String type;

	@Override
	public String getEndPoint() {
		return "www.google.com";
	}
 }