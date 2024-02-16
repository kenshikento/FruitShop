package com.store.service;

public class Fruit implements FruitService{
	   
	public FruitService fruitService;

	public Fruit(FruitService fruitService) {
		this.fruitService = fruitService;
	}

	public String getEndPoint() {
		return fruitService.getEndPoint();
	}
 }