package com.store.service;

public class FruitFactory  {
	   
	public FruitType type;

	public FruitService getInstanceType(FruitType type) {
		switch(type) {
	    case STRAWBERRY:
	        return new Fruit(new StrawberryService());
	    case APPLES:
	        return new Fruit(new AppleService());
	    default:
	        throw new IllegalArgumentException("Unknown Service ");
	    }
	}
 }